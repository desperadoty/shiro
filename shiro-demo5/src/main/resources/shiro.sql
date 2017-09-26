CREATE TABLE IF NOT EXISTS sys_users (
  id BIGINT AUTO_INCREMENT,
  username VARCHAR(100),
  password VARCHAR(100),
  salt VARCHAR(100),
  locked BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_users PRIMARY KEY (id)
)CHARSET=UTF8 ENGINE=InnoDB;

CREATE UNIQUE INDEX idx_sys_users_username ON sys_users(username);

CREATE TABLE IF NOT EXISTS sys_roles (
  id BIGINT AUTO_INCREMENT,
  role VARCHAR(100),
  description VARCHAR(100),
  available BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_roles PRIMARY KEY (id)
)CHARSET=UTF8 ENGINE=InnoDB;

CREATE UNIQUE INDEX idx_sys_roles_role ON sys_roles(role);

CREATE TABLE IF NOT EXISTS sys_permissions (
  id BIGINT AUTO_INCREMENT,
  permission VARCHAR(100),
  description VARCHAR(100),
  available BOOL DEFAULT FALSE,
  CONSTRAINT pk_sys_permissions PRIMARY KEY (id)
) CHARSET=UTF8 ENGINE=InnoDB;

CREATE UNIQUE INDEX idx_sys_permissions_permission ON sys_permissions(permission);

CREATE TABLE IF NOT EXISTS sys_users_roles (
  user_id BIGINT,
  role_id BIGINT,
  CONSTRAINT pk_sys_users_roles PRIMARY KEY (user_id,role_id)
)CHARSET=UTF8 ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS sys_roles_permissions (
  role_id BIGINT,
  permission_id BIGINT,
  CONSTRAINT pk_sys_roles_permissions PRIMARY KEY (role_id,permission_id)
)CHARSET=UTF8 ENGINE=InnoDB;