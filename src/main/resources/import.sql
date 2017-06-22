INSERT INTO `role` VALUES (1,'ADMIN');
INSERT INTO t30001 VALUES (1,null,null,null,null,null,null);
INSERT INTO t30002 VALUES (1,null,null,null,null,null,null);
INSERT INTO t30004 VALUES (1000,null,null,null,null,null,null,null,null,null,null);
INSERT INTO t30007 VALUES (100,null,null,null,null,null,null,null);

CREATE TABLE `t30004_bkp` (
  `t_gen_code` varchar(255) NOT NULL,
  `t_active_flag` varchar(255) DEFAULT NULL,
  `t_control_drug` varchar(255) DEFAULT NULL,
  `t_drug_therap_cls_code` varchar(255) DEFAULT NULL,
  `t_drug_use` varchar(255) DEFAULT NULL,
  `t_entry_date` datetime DEFAULT NULL,
  `t_entry_user` varchar(255) DEFAULT NULL,
  `t_lang1_name` varchar(255) DEFAULT NULL,
  `t_lang2_nam` varchar(255) DEFAULT NULL,
  `t_upd_date` datetime DEFAULT NULL,
  `t_upd_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`t_gen_code`)
);


CREATE TRIGGER `beforet30004Delete` 
BEFORE DELETE ON `t30004` 
FOR EACH ROW insert into t30004_bkp values(old.t_gen_code,old.t_active_flag,
old.t_control_drug,old.t_drug_therap_cls_code,old.t_drug_use,old.t_entry_date,old.t_entry_user,
old.t_lang1_name,old.t_lang2_nam,old.t_upd_date,old.t_upd_user);
