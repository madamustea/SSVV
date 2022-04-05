package ssvv.example;

import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.*;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.Assert.assertTrue;

public class IntegrationTest {
    private StudentRepository repStud;
    private TemaRepository repoTema;
    private NotaRepository repoNota;
    private Service serv;
    private StudentValidator valStud;
    private TemaValidator valTema;
    private NotaValidator valNota;

    @Test
    public void tc_addStudent()
    {   Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        service.saveStudent("1a","ana",935);
        assertTrue( service.findAllStudents().iterator().next().getID().equals("1a") );
        assertTrue( service.findAllStudents().iterator().next().getNume().equals("ana") );
        assertTrue( service.findAllStudents().iterator().next().getGrupa() == 935 );

    }

    @Test
    public void tc_addAssignment()
    {   Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        service.saveTema("t1","aaa",10,9);
       assertTrue( service.findAllTeme().iterator().next().getID().equals("t1") );
        System.out.println(service.findAllTeme().iterator().next().getID().equals("t1"));
        assertTrue( service.findAllTeme().iterator().next().getDescriere().equals("aaa") );
        assertTrue( service.findAllTeme().iterator().next().getDeadline() ==  10);
        assertTrue( service.findAllTeme().iterator().next().getStartline() ==  9);

    }

    @Test
    public void tc_addGrade()
    {   Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        Pair<String,String> idNota= new Pair<String,String>("1a","t1");
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        service.saveStudent("1a","ana",935);
        service.saveTema("t1","aaa",10,9);
       assertTrue(service.saveNota("1a","t1",10,10,"good")==0);
       /* assertTrue( service.findAllNote().iterator().next().getID().equals(idNota));
        assertTrue( service.findAllNote().iterator().next().getNota()==10);
        assertTrue( service.findAllNote().iterator().next().getSaptamanaPredare()==10);
        assertTrue( service.findAllNote().iterator().next().getFeedback().equals("good"));*/


    }

    @Test
    public void tc_4(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        Pair<String,String> idNota= new Pair<String,String>("1a","t1");
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        assertTrue(service.saveStudent("1a","ana",935)==0);
        assertTrue(service.saveTema("t1","aaa",10,9)==0);
        assertTrue(service.saveNota("1a","t1",10,10,"good")==0);
    }

}
