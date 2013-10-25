package net.lacnic.sisregistro.admin.web.login;

import java.util.UUID;

import net.lacnic.sisregistro.admin.web.bases.BasePanel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.extensions.markup.html.captcha.CaptchaImageResource;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.value.ValueMap;

/**
 * Panel de login.
 * @see org.apache.wicket.authentication.panel.SignInPanel
 */
public class LoginPanel extends BasePanel {

	private final static int CAPTCHA_THRESHOLD = 3; // a la 4ta vez pide captcha

	private TextField<String> username;
	private PasswordTextField password;

	private boolean captchaing;
	private Image captchaImage;
	private TextField<String> captchaTextField;
	private CaptchaImageResource captchaImageResource;

	private FeedbackPanel feedback = new FeedbackPanel("feedback");

	private boolean ajaxLogin;

	public final class SignInForm extends StatelessForm<Void> {
		private final ValueMap properties = new ValueMap();
		private String captchaText;

		public SignInForm(final String id, boolean ajax) {
			super(id);

			ajaxLogin = ajax;

			setOutputMarkupId(true);

			feedback.setOutputMarkupId(true);

			username = new TextField<String>("username", new PropertyModel<String>(properties, "username"));
			username.setType(String.class);
			add(username);

			password = new PasswordTextField("password", new PropertyModel<String>(properties, "password"));
			password.setType(String.class);
			add(password);

			captchaImageResource = new CaptchaImageResource(getCaptchaText());
			generateNewCaptcha();
			captchaImage = new Image("captchaImage", captchaImageResource);
			captchaImage.setVisible(false);
			add(captchaImage);

			captchaTextField = new TextField<String>("captcha", new PropertyModel<String>(properties, "captcha")) {
				@Override
				protected void onComponentTag(final ComponentTag tag) {
					super.onComponentTag(tag);
					tag.put("value", "");
				}
			};
			captchaTextField.setType(String.class);
			captchaTextField.setVisible(false);
			add(captchaTextField);

			AjaxButton ajaxSubmitButton = new AjaxButton("ajax-submit", this) {
				@Override
				protected void onSubmit(AjaxRequestTarget t, Form<?> form) {
					refresh(t);
				}

				@Override
				protected void onError(AjaxRequestTarget t, Form<?> form) {
					refresh(t);
				}

				private void refresh(AjaxRequestTarget t) {
					t.addComponent(feedback);
					t.addComponent(LoginPanel.this);
				}
			};
			add(ajaxSubmitButton);
			ajaxSubmitButton.setVisible(ajax);

			Button submitButton = new Button("submit");
			add(submitButton);
			submitButton.setVisible(!ajax);
		}

		private void generateNewCaptcha() {
			captchaText = UUID.randomUUID().toString().toUpperCase().substring(0, 4);
			captchaImageResource.getChallengeIdModel().setObject(captchaText);
		}

		private String getCaptchaText() {
			return captchaText;
		}

		@Override
		public final void onSubmit() {
			boolean captchaOk = true;

			if (captchaing) {
				captchaOk = getCaptcha().equalsIgnoreCase(captchaImageResource.getChallengeIdModel().getObject());
			}

			if (!captchaOk) {
//				log.error("error en captcha. se ingresó: " + getCaptcha() + ", se esperaba: "
//						+ captchaImageResource.getChallengeIdModel().getObject());
			}

			if (captchaOk && signIn(getUsername(), getPassword())) {
				onSignInSucceeded();
			} else {
				onSignInFailed();
			}

			if (!ajaxLogin && captchaing) {
				generateNewCaptcha();
				captchaImageResource.invalidate();
			}
		}
	}

	public LoginPanel(String id) {
		this(id, false);
	}

	public LoginPanel(String id, boolean ajax) {
		super(id);
		add(feedback);

		SignInForm f = new SignInForm("loginForm", ajax);
		add(f);
	}

	public String getPassword() {
		return password.getInput();
	}

	public String getUsername() {
		return username.getDefaultModelObjectAsString();
	}

	public String getCaptcha() {
		return captchaTextField.getDefaultModelObjectAsString();
	}

	public boolean signIn(String username, String password) {
		return AuthenticatedWebSession.get().signIn(username, password);
	}

	protected void onSignInFailed() {
		/*WebServiceAuthenticatedWebSession session = (WebServiceAuthenticatedWebSession) Session.get();

		captchaing = session.getIntentosLogin() >= CAPTCHA_THRESHOLD;
		captchaImage.setVisible(captchaing);
		captchaTextField.setVisible(captchaing);*/

		error(getLocalizer().getString("signInFailed", this, "Error al logearse"));

	}

	protected void onSignInSucceeded() {
		if (!continueToOriginalDestination()) {
			setResponsePage(getApplication().getHomePage());
		}
	}
}
