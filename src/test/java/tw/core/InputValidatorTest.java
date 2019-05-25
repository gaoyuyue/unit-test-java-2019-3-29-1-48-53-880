package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    @Test
    public void should_return_false_when_input_number_string_count_is_not_4() {
        InputValidator inputValidator = new InputValidator();
        Assert.assertFalse(inputValidator.validate("1 2 3"));
        Assert.assertFalse(inputValidator.validate("1 2 3 4 5"));
        Assert.assertFalse(inputValidator.validate(""));
    }
}
