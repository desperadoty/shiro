DELETE FROM users;
DELETE FROM user_roles;
DELETE FROM roles_permissions;

INSERT INTO users(username, password, password_salt) VALUES ('yvette','123456',NULL );
INSERT INTO user_roles(username, role_name) VALUES ('yvette','role1');
INSERT INTO user_roles(username, role_name) VALUES ('yvette','role2');
INSERT INTO roles_permissions(role_name, permission) VALUES ('role1','+user1+10');
INSERT INTO roles_permissions(role_name, permission) VALUES ('role1','user1:*');
INSERT INTO roles_permissions(role_name, permission) VALUES ('role1','+user2+10');
INSERT INTO roles_permissions(role_name, permission) VALUES ('role1','user2:*');
