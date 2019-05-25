package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer defaultAnswer;

    @Before
    public void before() {
        defaultAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_return_answer() {
        Assert.assertNotNull(defaultAnswer);
    }

    @Test
    public void should_pass_validate() throws OutOfRangeAnswerException {
        defaultAnswer.validate();
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throw_out_of_range_answer_exception_when_answer_have_number_more_than_10() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 22 3 4");
        answer.validate();
    }

    @Test
    public void should_return_0A0B_when_no_number_is_correct() {
        Answer answer = Answer.createAnswer("7 9 5 8");
        Record record = defaultAnswer.check(answer);
        Assert.assertEquals("0A0B", record.getValue());
    }

    @Test
    public void should_return_4A0B_when_all_number_is_correct() {
        Record record = defaultAnswer.check(defaultAnswer);
        Assert.assertEquals("4A0B", record.getValue());
    }
}