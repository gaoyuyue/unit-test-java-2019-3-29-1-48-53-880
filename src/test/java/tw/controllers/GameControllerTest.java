package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;
import tw.views.GameView;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    @Mock
    private GameView gameView;
    @Mock
    private InputCommand inputCommand;
    @Mock
    private AnswerGenerator answerGenerator;
    @Mock
    private Game game;

    private Answer correctAnswer;
    private Answer incorrectAnswer;
    private GameController gameController;

    @Before
    public void before() throws Exception {
        MockitoAnnotations.initMocks(this);
        correctAnswer = Answer.createAnswer("1 2 3 4");
        incorrectAnswer = Answer.createAnswer("2 3 4 5");

        when(answerGenerator.generate()).thenReturn(correctAnswer);
        gameController = new GameController(game, gameView);
    }

    @Test
    public void should_display_guess_result_when_play() throws IOException {
        when(inputCommand.input()).thenReturn(correctAnswer);
        when(game.guessHistory()).thenReturn(new ArrayList<>());
        when(game.checkStatus()).thenReturn("");
        when(game.checkCoutinue()).thenReturn(true, false);
        when(game.guess(incorrectAnswer)).thenReturn(new GuessResult("", incorrectAnswer));
        gameController.play(inputCommand);

        verify(gameView).showGuessResult(any());
        verify(gameView).showGuessHistory(anyList());
        verify(gameView).showGameStatus(anyString());
    }
}