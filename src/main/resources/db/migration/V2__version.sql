ALTER TABLE join_table_instructor
DROP
FOREIGN KEY FK_JOINTABLE_INSTRUCTOR_ON_USER;

ALTER TABLE join_table_mentor
DROP
FOREIGN KEY FK_JOINTABLE_MENTOR_ON_USER;

ALTER TABLE join_table_ta
DROP
FOREIGN KEY FK_JOINTABLE_TA_ON_USER;

DROP TABLE join_table_instructor;

DROP TABLE join_table_mentor;

DROP TABLE join_table_ta;

DROP TABLE join_table_user;

DROP TABLE mapped_super_instructor;

DROP TABLE mapped_super_mentor;

DROP TABLE mapped_super_ta;

DROP TABLE single_table_user;

DROP TABLE tpc_instructor;

DROP TABLE tpc_mentor;

DROP TABLE tpc_ta;

DROP TABLE tpc_user;