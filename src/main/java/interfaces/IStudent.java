package interfaces;

import model.Lesson;
import model.Task;
import model.User;

public interface IStudent {

    void showLessons(User student);

    void showTask(User student);

    void sendAnswer(User student);

    void showGrades(User student);

    void showAnswerStatus(User student);


}
