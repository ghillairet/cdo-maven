package org.eclipselabs;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.net4j.CDONet4jSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipselabs.model.ModelFactory;
import org.eclipselabs.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CDOTest {

    private CDOServer server;

    @Before
    public void setUp() {
        server = new CDOServer();
        server.activate();
    }

    @After
    public void tearDown() {
        server.deactivate();
    }

    @Test
    public void test() throws CommitException {
        CDONet4jSession session = server.getSession(true);
        {
            CDOTransaction transaction = session.openTransaction();
            CDOResource users = transaction.createResource("users");
            users.getContents().add(ModelFactory.eINSTANCE.createUser());
            transaction.commit();
            transaction.close();
        }
        {
            CDOView transaction = session.openView();
            CDOResource users = transaction.getResource("users");

            assertNotNull(users);
            assertEquals(1, users.getContents().size());
            assertTrue(users.getContents().get(0) instanceof User);
            transaction.close();
        }
        {
            CDOTransaction transaction = session.openTransaction();
            CDOResource users = transaction.getResource("users");

            User user = (User) users.getContents().get(0);
            user.setId(1);
            user.setName("Bob");

            transaction.commit();
            transaction.close();
        }
        {
            CDOView transaction = session.openView();
            CDOResource users = transaction.getResource("users");

            assertNotNull(users);

            User user = (User) users.getContents().get(0);

            assertEquals(1, user.getId());
            assertEquals("Bob", user.getName());
            transaction.close();
        }
    }

}
