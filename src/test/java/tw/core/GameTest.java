package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */
public class GameTest {
    private Game game;
    private Answer defaultAnswer;

    @Before
    public void before() throws OutOfRangeAnswerException {
        defaultAnswer = Answer.createAnswer("1 2 3 4");
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(defaultAnswer);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_return_record_of_every_guess_result_when_guess_history() {
        game.guess(Answer.createAnswer("1 2 3 4"));
        game.guess(Answer.createAnswer("5 6 7 8"));
        game.guess(Answer.createAnswer("1 3 5 8"));

        List<GuessResult> guessResults = game.guessHistory();

        Assert.assertEquals(3, guessResults.size());

        Assert.assertEquals("4A0B", guessResults.get(0).getResult());
        Assert.assertEquals("1 2 3 4", guessResults.get(0).getInputAnswer().toString());

        Assert.assertEquals("0A0B", guessResults.get(1).getResult());
        Assert.assertEquals("5 6 7 8", guessResults.get(1).getInputAnswer().toString());

        Assert.assertEquals("1A1B", guessResults.get(2).getResult());
        Assert.assertEquals("1 3 5 8", guessResults.get(2).getInputAnswer().toString());
    }

    @Test
    public void should_return_the_success_status_when_guess_and_input_is_correct() {
        game.guess(Answer.createAnswer("1 6 2 8"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        Assert.assertEquals("success", game.checkStatus());
    }

    @Test
    public void should_return_the_fail_status_when_guess_action_count_over_or_equal_6() {
        game.guess(Answer.createAnswer("1 7 4 2"));
        game.guess(Answer.createAnswer("9 2 1 4"));
        game.guess(Answer.createAnswer("5 6 2 1"));
        game.guess(Answer.createAnswer("8 1 4 9"));
        game.guess(Answer.createAnswer("1 3 4 2"));
        game.guess(Answer.createAnswer("9 6 7 5"));
        Assert.assertEquals("fail", game.checkStatus());
    }

    @Test
    public void should_return_the_continue_status_when_guess_action_count_less_than_6() {
        game.guess(Answer.createAnswer("2 1 3 4"));
        game.guess(Answer.createAnswer("7 1 2 9"));
        game.guess(Answer.createAnswer("5 4 7 3"));
        Assert.assertEquals("continue", game.checkStatus());
    }

    @Test
    public void should_return_false_when_correct_guess() {
        game.guess(Answer.createAnswer("4 5 6 7"));
        game.guess(Answer.createAnswer("2 3 4 5"));
        game.guess(Answer.createAnswer("1 2 3 4"));
        Assert.assertFalse(game.checkCoutinue());
    }

    @Test
    public void should_return_true_when_not_correct_guess_number_less_than_6() {
        game.guess(Answer.createAnswer("2 1 3 4"));
        game.guess(Answer.createAnswer("7 1 2 9"));
        game.guess(Answer.createAnswer("5 4 7 3"));
        Assert.assertTrue(game.checkCoutinue());
    }
}
