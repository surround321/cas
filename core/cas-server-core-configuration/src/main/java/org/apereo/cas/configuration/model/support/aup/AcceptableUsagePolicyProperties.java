package org.apereo.cas.configuration.model.support.aup;

import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties;
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapProperties;

import java.io.Serializable;

/**
 * This is {@link AcceptableUsagePolicyProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */

public class AcceptableUsagePolicyProperties implements Serializable {
    private static final long serialVersionUID = -7703477581675908899L;
    /**
     * Control AUP via LDAP.
     */
    private Ldap ldap = new Ldap();

    /**
     * Control AUP via Redis.
     */
    private Jdbc jdbc = new Jdbc();
    
    /**
     * AUP attribute to choose in order to determine whether policy
     * has been accepted or not.
     */
    private String aupAttributeName = "aupAccepted";

    public String getAupAttributeName() {
        return aupAttributeName;
    }

    public void setAupAttributeName(final String aupAttributeName) {
        this.aupAttributeName = aupAttributeName;
    }

    public Jdbc getJdbc() {
        return jdbc;
    }

    public void setJdbc(final Jdbc redis) {
        this.jdbc = redis;
    }

    public Ldap getLdap() {
        return ldap;
    }

    public void setLdap(final Ldap ldap) {
        this.ldap = ldap;
    }

    public static class Jdbc extends AbstractJpaProperties {
        private static final long serialVersionUID = -1325011278378393385L;

        /**
         * The table name in the database that holds the AUP attribute to update for the user.
         */
        private String tableName;

        public String getTableName() {
            return tableName;
        }

        public void setTableName(final String tableName) {
            this.tableName = tableName;
        }
    }
    
    public static class Ldap extends AbstractLdapProperties {
        private static final long serialVersionUID = -7991011278378393382L;
        /**
         * Base DN to start the search for user accounts.
         */
        private String baseDn;
        /**
         * Search filter to use.
         * Syntax is {@code cn={user}} or {@code cn={0}}
         */
        private String userFilter;

        public String getBaseDn() {
            return baseDn;
        }

        public void setBaseDn(final String baseDn) {
            this.baseDn = baseDn;
        }

        public String getUserFilter() {
            return userFilter;
        }

        public void setUserFilter(final String userFilter) {
            this.userFilter = userFilter;
        }
    }
    
}
