package tw.core;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;
    @Before
    public void before() {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void should_return_random_numbers_string() {
        String nums = randomIntGenerator.generateNums(30, 5);
        Assert.assertNotNull(nums);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_illegal_argument_exception_when_digitmax_less_than_numbers_of_need() {
        randomIntGenerator.generateNums(4, 6);
    }
}