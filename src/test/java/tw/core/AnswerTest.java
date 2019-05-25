package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    public void should_return_answer() {
        Assert.assertNotNull(Answer.createAnswer("1 2 3 4"));
    }

    @Test
    public void should_pass_validate() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 2 3 4");
        answer.validate();
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throw_out_of_range_answer_exception_when_answer_have_number_more_than_10() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 22 3 4");
        answer.validate();
    }
}