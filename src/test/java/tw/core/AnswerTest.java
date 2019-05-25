package tw.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    @Test
    public void should_return_answer() {
        Assert.assertNotNull(Answer.createAnswer("1 2 3 4"));
    }
}