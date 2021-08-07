package com.example.clinicappproject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ProjectUnitTest {
    @Mock
    PatientLoginTest patientView;

    @Mock
    DoctorLoginTest doctorView;

    @Mock
    Model model;

    @Test
    public void testCorrectPatient() {
        when(patientView.getUsername()).thenReturn("test1");
        when(patientView.getPassword()).thenReturn("password1");
        Patient testPatient = new Patient();
        testPatient.setUsername("test1");
        testPatient.setPassword("password1");
        Presenter presenter = new Presenter(model, patientView);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((Presenter) invocation.getArguments()[0]).onSuccess(testPatient);
                return null;
            }
        }).when(model).patientLogin(presenter, "test1", "password1");
        presenter.checkPatientCredentials();
        verify(patientView).onLoginSuccess(testPatient);


    }

    @Test
    public void testIncorrectPatient() {
        when(patientView.getUsername()).thenReturn("test1");
        when(patientView.getPassword()).thenReturn("wrongpassword");
        Patient testPatient = new Patient();
        testPatient.setUsername("test1");
        testPatient.setPassword("wrongpassword");
        Presenter presenter = new Presenter(model, patientView);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((Presenter) invocation.getArguments()[0]).onFailure();
                return null;
            }
        }).when(model).patientLogin(presenter, "test1", "wrongpassword");
        presenter.checkPatientCredentials();
        verify(patientView).onLoginFailure();


    }

    @Test
    public void testCorrectDoctor() {
        when(doctorView.getUsername()).thenReturn("test1");
        when(doctorView.getPassword()).thenReturn("password1");
        Doctor testDoctor = new Doctor();
        testDoctor.setUsername("test1");
        testDoctor.setPassword("password1");
        Presenter presenter = new Presenter(model, doctorView);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((Presenter) invocation.getArguments()[0]).onSuccess(testDoctor);
                return null;
            }
        }).when(model).doctorLogin(presenter, "test1", "password1");
        presenter.checkDoctorCredentials();
        verify(doctorView).onLoginSuccess(testDoctor);


    }

    @Test
    public void testIncorrectDoctor() {
        when(doctorView.getUsername()).thenReturn("test1");
        when(doctorView.getPassword()).thenReturn("wrongpassword");
        Doctor testDoctor = new Doctor();
        testDoctor.setUsername("test1");
        testDoctor.setPassword("wrongpassword");
        Presenter presenter = new Presenter(model, doctorView);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                ((Presenter) invocation.getArguments()[0]).onSuccess(testDoctor);
                return null;
            }
        }).when(model).doctorLogin(presenter, "test1", "wrongpassword");
        presenter.checkDoctorCredentials();
        verify(doctorView).onLoginSuccess(testDoctor);

    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}