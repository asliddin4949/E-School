package interfaces;

import model.User;

public interface ITeacher {
    void showLessons(User teacher);
    void addTask(User teacher);
    void setStatus(User teacher);
    void gradeAnswers(User teacher);
}
