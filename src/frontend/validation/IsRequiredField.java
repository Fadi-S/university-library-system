package frontend.validation;

import javax.swing.*;

public class IsRequiredField extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        return ! ((JTextField) input).getText().isEmpty();
    }
}
