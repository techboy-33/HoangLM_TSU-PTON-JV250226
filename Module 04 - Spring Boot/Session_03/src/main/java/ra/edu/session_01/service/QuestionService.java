package ra.edu.session_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.session_01.model.dto.QuestionDTO;
import ra.edu.session_01.model.entity.Exam;
import ra.edu.session_01.model.entity.Question;
import ra.edu.session_01.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ExamService examService;

    public List<Question> getQuestionByExamId(long examId) {
        return questionRepository.findAllByExam_Id(examId);
    }

    public Question saveQuestion(QuestionDTO questionDTO, long examId) {
        Exam exam = examService.findById(examId);
        Question question = Question
                .builder()
                .exam(exam)
                .content(questionDTO.getContent())
                .build();
        return questionRepository.save(question);
    }

    public Question getQuestionById(long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }
}
