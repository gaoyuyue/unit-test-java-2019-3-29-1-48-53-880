package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator;
    @Before
    public void before() {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_false_when_input_number_string_count_is_not_4() {
        Assert.assertFalse(inputValidator.validate("1 2 3"));
        Assert.assertFalse(inputValidator.validate("1 2 3 4 5"));
        Assert.assertFalse(inputValidator.validate(""));
    }

    @Test
    public void should_return_false_when_input_number_string_count_is_4_but_has_number_is_more_than_10() {
        Assert.assertFalse(inputValidator.validate("1 2 3 11"));
    }

    @Test
    public void should_return_true_when_input_number_string_count_is_4_and_all_number_is_less_than_10() {
        Assert.assertTrue(inputValidator.validate("2 3 4 5"));
    }
}
