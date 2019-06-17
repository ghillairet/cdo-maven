package org.eclipselabs;

import org.eclipse.emf.cdo.net4j.CDONet4jSession;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.IStore;
import org.eclipse.emf.cdo.server.db.CDODBUtil;
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy;
import org.eclipse.emf.cdo.server.embedded.CDOEmbeddedRepositoryConfig;
import org.eclipse.net4j.db.DBUtil;
import org.eclipse.net4j.db.IDBAdapter;
import org.eclipse.net4j.db.IDBConnectionProvider;
import org.eclipse.net4j.db.h2.H2Adapter;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipselabs.model.ModelPackage;
import org.h2.jdbcx.JdbcDataSource;

import java.util.Map;

public class CDOServer extends CDOEmbeddedRepositoryConfig {

    private CDONet4jSession session;

    public CDOServer() {
        super("test");
    }

    public synchronized CDONet4jSession getSession(boolean openOnDemand) {
        checkActive();

        if (session == null && openOnDemand) {
            session = openClientSession();
            session.addListener(new LifecycleEventAdapter() {
                @Override
                protected void onDeactivated(ILifecycle lifecycle) {
                    if (lifecycle == session) {
                        session = null;
                    }
                }
            });
        }

        return session;
    }

    @Override
    public IStore createStore(IManagedContainer container) {
        IMappingStrategy mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(true, true);
        mappingStrategy.getProperties().put(IMappingStrategy.Props.FORCE_NAMES_WITH_ID, "true");

        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

        IDBAdapter dbAdapter = new H2Adapter();
        IDBConnectionProvider dbConnectionProvider = DBUtil.createConnectionProvider(dataSource);

        return CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider);
    }

    @Override
    public boolean isInitialPackage(IRepository repository, String nsURI) {
        return nsURI.equals(ModelPackage.eNS_URI);
    }

    @Override
    public void initProperties(IManagedContainer container, Map<String, String> properties) {
        properties.put(IRepository.Props.SUPPORTING_AUDITS, Boolean.toString(true));
        properties.put(IRepository.Props.SUPPORTING_BRANCHES, Boolean.toString(true));
    }
}
