package edu.fcu.cs1133.Service;

import edu.fcu.cs1133.model.Enrollment;
import edu.fcu.cs1133.model.EnrollmentId;
import edu.fcu.cs1133.repository.EnrollmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentsRepository enrollmentsRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentsRepository.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(EnrollmentId id) {
        return enrollmentsRepository.findById(id);
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        // Additional logic can be added here, e.g., check if student is already enrolled
        return enrollmentsRepository.save(enrollment);
    }

    public Enrollment updateEnrollment(EnrollmentId id, Enrollment enrollmentDetails) {
        Optional<Enrollment> optionalEnrollment = enrollmentsRepository.findById(id);
        if (optionalEnrollment.isPresent()) {
            Enrollment existingEnrollment = optionalEnrollment.get();
            // Only grade and enrollmentDate are likely to be updated
            existingEnrollment.setGrade(enrollmentDetails.getGrade());
            existingEnrollment.setEnrollmentDate(enrollmentDetails.getEnrollmentDate());
            return enrollmentsRepository.save(existingEnrollment);
        }
        return null; // Or throw an exception
    }

    public void deleteEnrollment(EnrollmentId id) {
        enrollmentsRepository.deleteById(id);
    }

    public List<Enrollment> getEnrollmentsByCourseId(int courseId) {
        return enrollmentsRepository.findByCourseCourseId(courseId);
    }

    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        return enrollmentsRepository.findByStudentStudentId(studentId);
    }
}
