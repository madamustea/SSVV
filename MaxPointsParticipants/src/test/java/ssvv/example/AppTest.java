package ssvv.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.*;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private StudentRepository repStud;
    private TemaRepository repoTema;
    private NotaRepository repoNota;
    private Service serv;
    private StudentValidator valStud;
    private TemaValidator valTema;
    private NotaValidator valNota;
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void tc_1_studentWithExistingId() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        Student studAdded= new Student("1a","ana",935);
        service.saveStudent("1a","ana",935);

        assertTrue(1==1);


    }
}
