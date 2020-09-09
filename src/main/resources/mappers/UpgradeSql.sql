ALTER TABLE `open_mediation`.`report_adnetwork_account`
ADD COLUMN `publisher_id` INT(11) NOT NULL AFTER `adn_id`;

ALTER TABLE `open_mediation`.`report_adnetwork_account`
ADD COLUMN `adn_account_name` VARCHAR(200) NULL AFTER `adn_account_id`,
CHANGE COLUMN `adn_account_id` `adn_account_id` INT(11) NULL DEFAULT '0' COMMENT 'AdNetworkId账号ID' ,
CHANGE COLUMN `adn_account_owner` `adn_account_owner` TINYINT(3) NULL DEFAULT '0' COMMENT 'Account Owner: 0,Publisher;1,AdTiming;2,No Setting' ;

ALTER TABLE `open_mediation`.`report_adnetwork_account`
ADD COLUMN `auth_type` TINYINT(3) NOT NULL DEFAULT 0 AFTER `auth_key`;

ALTER TABLE `open_mediation`.`report_adnetwork_account`
ADD COLUMN `currency` VARCHAR(3) NOT NULL DEFAULT 'USD' AFTER `auth_type`;

ALTER TABLE `open_mediation`.`report_adnetwork_account`
ADD COLUMN `reason` VARCHAR(2000) NULL DEFAULT NULL AFTER `status`;


UPDATE `open_mediation`.`um_permission` SET `api_path` = '/sdk/dev_app/get\n/sdk/adnetworks\n/sdk/adnetwork/placements\n/sdk/devices\n/sdk/dev_app/dev_result/update\n/sdk/device/create\n/sdk/dev_app/create\n/sdk/dev_app/operation\n/sdk/device/delete' WHERE (`id` = '2600');


ALTER TABLE `open_mediation`.`om_adnetwork_app_change`
ADD COLUMN `new_report_account_id` INT(11) NOT NULL DEFAULT 0 AFTER `report_account_id`;

ALTER TABLE `open_mediation`.`om_adnetwork_app_change`
CHANGE COLUMN `id` `id` INT(11) NOT NULL DEFAULT '0' ;


INSERT INTO `um_permission` (`id`, `pid`, `type`, `title`, `name`, `api_path`, `sort_index`, `sort_index_ext`, `descn`, `status`, `create_time`, `lastmodify`)
VALUES
	(31, 11, 'perm', 'Company Settings', 'company', '/publisher/get\n/publisher/update\n/publisher/create', 0, 0, NULL, 1, '2020-04-21 17:47:18', '2020-04-22 11:36:17'),
	(32, 11, 'perm', 'App Settings', 'app_settings', '/publisher/get\n/publisher/update\n/publisher/create', 0, 0, NULL, 1, '2020-04-21 17:47:18', '2020-04-22 11:36:17'),
	(3100, 31, 'action', 'Query', 'query', '/publisher/payment_info/get\n/publisher/get\n/publisher/account/list\n/publisher/payment_info/list\n/publisher/account/select/list', 0, 0, NULL, 1, '2020-04-21 17:48:35', '2020-05-11 19:22:41'),
	(3101, 31, 'action', 'Add', 'add', '/publisher/create\n/publisher/account/create\n/publisher/payment_info/create\n/publisher/promote/create', 0, 0, NULL, 1, '2020-04-21 17:48:35', '2020-05-12 14:12:34'),
	(3102, 31, 'action', 'Edit', 'edit', '/publisher/update\n/publisher/account/update\n/publisher/account/delete\n/publisher/payment_info/update\n/report/google/refreshToken/save\n/report/callback/oauth2authorize\n/register/publisher/complete\n/publisher/verify/ads\n/publisher/promote/update\n/publisher/promote/get', 0, 0, NULL, 1, '2020-04-23 16:00:12', '2020-05-12 14:14:49'),
	(3200, 32, 'action', 'Query', 'query', '/publisher/list\n/publisher/select/list', 0, 0, NULL, 1, '2020-04-21 17:48:35', '2020-04-23 16:03:16'),
	(3201, 32, 'action', 'Add', 'add', '/publisher/create', 0, 0, NULL, 1, '2020-04-21 17:48:35', '2020-04-23 15:55:39'),
	(3202, 32, 'action', 'Edit', 'edit', '/publisher/get\n/publisher/update\n/adnetwork/app/status/update', 0, 0, NULL, 1, '2020-04-23 15:56:54', '2020-04-26 13:09:23');
INSERT INTO `um_role_permission` (`role_id`, `permission_id`, `create_time`)
VALUES
	(1, 31, '2020-04-21 17:49:34'),
	(1, 32, '2020-04-21 17:49:34'),
	(1, 3100, '2020-04-21 17:49:34'),
	(1, 3101, '2020-04-21 17:49:34'),
	(1, 3102, '2020-04-21 17:49:34'),
	(1, 3200, '2020-04-21 17:49:34'),
	(20, 31, '2020-04-14 16:12:21'),
	(20, 32, '2020-04-21 17:49:34'),
	(20, 3100, '2020-04-21 04:51:29'),
	(20, 3101, '2020-04-21 04:51:29'),
	(20, 3102, '2020-04-23 03:39:37'),
	(20, 3200, '2020-04-21 17:49:34'),
	(20, 3201, '2020-05-12 16:43:22'),
	(20, 3202, '2020-05-12 16:43:22'),
	(30, 31, '2020-02-20 03:26:11'),
	(30, 32, '2020-04-21 17:49:34'),
	(30, 3100, '2020-04-21 04:51:34'),
	(30, 3101, '2020-04-27 01:45:27'),
	(30, 3102, '2020-04-27 01:45:27'),
	(30, 3200, '2020-04-21 17:49:34'),
	(30, 3201, '2020-04-23 03:38:47'),
	(30, 3202, '2020-04-23 03:38:47'),
	(40, 31, '2020-02-20 03:26:11'),
	(40, 32, '2020-02-20 03:26:11'),
	(40, 3100, '2020-04-26 04:59:47'),
	(40, 3101, '2020-04-26 04:59:47'),
	(40, 3102, '2020-04-26 04:59:47'),
	(40, 3200, '2020-04-26 04:59:48'),
	(40, 3201, '2020-04-27 01:58:24'),
	(40, 3202, '2020-04-27 01:58:25'),
	(50, 31, '2020-02-20 03:26:11'),
	(50, 32, '2020-02-20 03:26:11'),
	(50, 3100, '2020-04-26 04:59:55'),
	(50, 3200, '2020-04-26 04:59:55');

INSERT INTO `open_mediation`.`um_role_permission` (`role_id`, `permission_id`) VALUES ('20', '1501');
INSERT INTO `open_mediation`.`um_role_permission` (`role_id`, `permission_id`) VALUES ('20', '1502');


ALTER TABLE `open_mediation`.`stat_lr`
ADD COLUMN `scene_id` INT(11) NOT NULL DEFAULT 0 AFTER `instance_id`;

2020-07-20:
UPDATE `open_mediation`.`um_permission` SET `api_path` = '/placement/get\n/placement/update\n/placement/scene/update\n/placement/create_update' WHERE (`id` = '1302');

UPDATE `open_mediation`.`um_permission` SET `api_path` = '/mediation/segment/save\n/mediation/segment/rule/delete\n/mediation/segment/resort/priority\n/mediation/rule/resort/priority\n/mediation/segment/update\n/mediation/segment/rule/update\n/mediation/segment/rule/instance/update\n/mediation/segment/rule/instance/create\n/mediation/segment/rule/instance/delete\n/mediation/segment/get\n/mediation/segment/rule/instance/delete\n/mediation/rule/resort/priority\n/mediation/segment/rule/delete\n/placement/get' WHERE (`id` = '1600');

CREATE TABLE `om_message_dict` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `page` varchar(50) DEFAULT NULL,
  `msg_key` varchar(50) DEFAULT NULL,
  `value` text,
  `name` varchar(30) NOT NULL DEFAULT '',
  `status` tinyint(3) DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastmodify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `page_key` (`page`,`msg_key`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8mb4;


/*
-- Query: SELECT * FROM open_mediation.om_message_dict
LIMIT 0, 1000

-- Date: 2020-08-15 10:15
*/
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (1,'pubapp','id_empty','Please enter App Store or Google Play URL.','',1,'2020-06-04 14:18:02','2020-06-19 11:48:14');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (2,'pubapp','id_pattern','The App ID is incorrect, please check again.','',1,'2020-06-04 14:18:02','2020-06-19 11:49:14');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (3,'pubapp','name_empty','Please enter app name.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (4,'pubapp','app_not_found','The app is not found in the store, please check the URL again.','',1,'2020-06-04 14:18:02','2020-06-19 11:50:17');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (5,'pubapp','coppa_not_allowed','It must be checked.','',1,'2020-06-04 14:18:02','2020-06-19 11:52:14');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (6,'pubapp','app_key_copied','Copied App Key value to the clipboard','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (7,'pubapp','ads_code_copied','Copied Code Snippet to the clipboard','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (8,'pubapp','status_update','Succeed','',1,'2020-06-04 14:18:02','2020-06-19 12:06:08');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (9,'pubapp','verify_success','Verified successfully.','',1,'2020-06-04 14:18:02','2020-06-19 11:52:48');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (10,'pubapp','alert_title','Congrats! Your App is created successfully.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (11,'pubapp','alert_content','Next steps: Create a placement to display ads in your app.','',1,'2020-06-04 14:18:02','2020-06-18 16:57:12');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (12,'pubapp','alert_button','Create','',1,'2020-06-04 14:18:02','2020-06-18 16:56:11');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (13,'placement','update_success','Update successfully.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (14,'placement','create_success','A NEW Placement has been created successfully.','',1,'2020-06-04 14:18:02','2020-06-19 12:01:16');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (15,'placement','scene_status','All changes have been saved.','',1,'2020-06-04 14:18:02','2020-06-19 11:55:23');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (16,'placement','name_empty','Please enter placement name.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (17,'placement','alert_adn_title','Your Placement has been created successfully.','',1,'2020-06-04 14:18:02','2020-06-19 11:56:07');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (18,'placement','alert_adn_content','Next steps: Setup ad network settings for monetize','',1,'2020-06-04 14:18:02','2020-06-18 18:15:23');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (19,'placement','alert_adn_button','Setup','',1,'2020-06-04 14:18:02','2020-06-19 11:56:34');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (20,'placement','alert_instance_new_title','Your Ad Network is Ready.','',1,'2020-06-04 14:18:02','2020-06-18 18:57:52');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (21,'placement','alert_instance_new_content','Next steps：Setup an Instance to Monitize','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (22,'placement','alert_instance_new_button','Setup Instance','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (23,'placement','alert_waterfall_title','Everything is ready.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (24,'placement','alert_waterfall_content','Next steps：Setup a Mediation Rule to Monitize','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (25,'placement','alert_waterfall_button','Setup Mediation Rule','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (26,'instance','update_success','All changes have been saved.','',1,'2020-06-04 14:18:02','2020-06-19 12:04:18');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (27,'instance','create_success','A NEW Instance has been created successfully.','',1,'2020-06-04 14:18:02','2020-06-19 12:01:05');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (28,'instance','adn_empty','Please select an Ad Network.','',1,'2020-06-04 14:18:02','2020-06-19 12:06:52');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (29,'instance','name_empty','Please enter the Instance name.','',1,'2020-06-04 14:18:02','2020-06-19 12:06:43');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (30,'instance','unit_id_empty','Please enter the Unit ID.','',1,'2020-06-04 14:18:02','2020-06-19 12:06:36');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (31,'instance','placement_key_exits','This Unit ID has already existed.','',1,'2020-06-04 14:18:02','2020-06-19 12:07:50');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (32,'scenes','name_empty','Please enter the Scene name.','',1,'2020-06-04 14:18:02','2020-06-19 12:08:00');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (33,'scenes','update_success','All changes have been saved.','',1,'2020-06-04 14:18:02','2020-06-19 12:04:28');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (34,'scenes','create_success','A NEW Scene has been created successfully.','',1,'2020-06-04 14:18:02','2020-06-19 12:00:56');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (35,'mediation','name_empty','Please enter the Mediation Rule Name.','',1,'2020-06-04 14:18:02','2020-06-19 12:08:08');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (36,'mediation','regions_empty','Regions can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (37,'mediation','optimized_type_empty','Please select the Optimized Type.','',1,'2020-06-04 14:18:02','2020-06-19 12:08:33');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (38,'mediation','channel_too_long','Data too long for Channel, Please control at 1000 characters','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (39,'mediation','update_success','All changes have been saved.','',1,'2020-06-04 14:18:02','2020-06-19 12:04:36');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (40,'mediation','create_success','A NEW Mediation Rule has been created successfully.','',1,'2020-06-04 14:18:02','2020-06-19 12:01:34');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (41,'mediation','remove_confirm','Are you sure?','',1,'2020-06-04 14:18:02','2020-06-19 12:09:28');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (42,'mediation','rule_instance_update','All changes have been saved.','',1,'2020-06-04 14:18:02','2020-06-19 12:09:44');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (43,'sdk','set_all','Please set all results','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (44,'sdk','select_one','Please select one Ad NetWork','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (45,'sdk','device_name_empty','Please enter the device name.','',1,'2020-06-04 14:18:02','2020-06-19 14:21:30');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (46,'sdk','id_empty','Please enter IDFA/GAID.','',1,'2020-06-04 14:18:02','2020-06-19 14:21:21');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (47,'abt','name_empty','Please enter the name.','',1,'2020-06-04 14:18:02','2020-06-19 14:21:16');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (48,'abt','name_pattern','The Name should less than 40 letters.','',1,'2020-06-04 14:18:02','2020-06-19 14:21:10');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (49,'abt','placement_empty','Please select the Placement.','',1,'2020-06-04 14:18:02','2020-06-19 14:21:06');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (50,'abt','setup_all_segments','Please set up the mediation rules for group B ','',1,'2020-06-04 14:18:02','2020-06-19 14:54:10');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (51,'abt','setup_app_unitid','Please fill all Unit IDs.','',1,'2020-06-04 14:18:02','2020-06-19 14:56:23');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (52,'abt','rule_empty','The mediation rule of group A can not be empty.','',1,'2020-06-04 14:18:02','2020-06-19 14:57:03');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (53,'appsettings','update_success','All changes have been saved.','',1,'2020-06-04 14:18:02','2020-06-19 12:05:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (54,'appsettings','create_success','Create successfully','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (55,'appsettings','copied_success','Copied to the clipboard','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (56,'appsettings','app_key','App Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (57,'appsettings','api_token','API Token can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (58,'appsettings','app_id','App ID can not be empty','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (59,'appsettings','system_user_access_token','System User Access Token can not be empty','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (60,'appsettings','game_id','Game ID can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (61,'appsettings','sdk_key','SDK Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (62,'appsettings','app_signature','App Signature can not be empty','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (63,'appsettings','adn_account','Please select an Ad Network Account.','',1,'2020-06-04 14:18:02','2020-06-19 14:58:13');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (64,'appsettings','plat_check','Platform mismatch.','',1,'2020-06-04 14:18:02','2020-06-19 14:58:31');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (65,'account','update_success','All changes have been saved.','',1,'2020-06-04 14:18:02','2020-06-19 12:05:10');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (66,'account','create_success','A NEW API Key has been created successfully.','',1,'2020-06-04 14:18:02','2020-06-19 12:02:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (67,'account','remove_success','The API Key has been removed.','',1,'2020-06-04 14:18:02','2020-06-19 14:58:55');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (68,'account','account_name','Account Name can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (69,'account','currency','Please select Currency. It should be as same as the setting in the Ad Network','',1,'2020-06-04 14:18:02','2020-06-19 15:00:05');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (70,'account','adn_empty','Ad Network can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (71,'account','app_key','App Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (72,'account','api_token','API Token can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (73,'account','client_id','Client ID can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (74,'account','client_secrect','Client Secrect can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (75,'account','refresh_token','Refresh Token can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (76,'account','reporting_api_key','Reporting API Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (77,'account','read_only_api_key','Read-Only API Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (78,'account','report_key','Report Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (79,'account','api_key','API Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (80,'account','inventory_report_id','Inventory Report ID can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (81,'account','publisher_reporting_api_key','Publisher Reporting API Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (82,'account','ad_reporting_api_key','Ad Reporting API Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (83,'account','user_id','User ID can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (84,'account','user_signature','User Signature can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (85,'account','report_api_skey','Report API SKey can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (86,'account','report_api_secret','Report API Secret can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (87,'account','user_name','User Name can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (88,'account','secret_key','Secret Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (89,'account','publisher_id','Publisher ID can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (90,'account','consumer_key','Consumer Key can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (91,'account','consumer_secret','Consumer Secret can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (92,'company','company_empty','Please enter Company Name.','',1,'2020-06-04 14:18:02','2020-06-04 16:03:51');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (93,'company','update_success_namechange','Updated! It will synchronize to Wire Transfer settings','',1,'2020-06-04 14:18:02','2020-06-19 15:01:33');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (94,'company','update_success','All changes have been saved.','',1,'2020-06-04 14:18:02','2020-06-19 12:05:24');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (95,'company','first_login','Please complete the company information first.','',1,'2020-06-04 14:18:02','2020-06-19 15:01:46');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (96,'company','company_name_change','It will synchronize to Wire Transfer settings','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (97,'company','country_empty','Base Country can not be empty.','',1,'2020-06-04 14:18:02','2020-06-19 15:02:14');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (98,'company','email_empty','Email can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (99,'company','email_pattern','Incorrect email address.','',1,'2020-06-04 14:18:02','2020-06-19 15:02:37');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (100,'company','address_empty','Address can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (101,'company','website_empty','Website can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (102,'company','website_pattern','Please input the full developer website URL in this field.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (103,'company','phone_empty','Phone can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (104,'promote','company_empty','Company Name can not be empty','',1,'2020-06-04 14:18:02','2020-06-19 15:03:07');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (105,'promote','regions_empty','Country can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (106,'promote','email_empty','Email can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (107,'promote','email_pattern','Incorrect mailbox format.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (108,'promote','save_success','All changes have been saved successfully.','',1,'2020-06-04 14:18:02','2020-06-19 15:03:59');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (109,'finance','update_success','Updated!','',1,'2020-06-04 14:18:02','2020-06-19 15:04:14');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (110,'finance','paypal_empty','Please fill in your Paypal account.','',1,'2020-06-04 14:18:02','2020-06-19 15:03:27');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (111,'finance','paypal_pattern','Incorrect email address.','',1,'2020-06-04 14:18:02','2020-06-19 15:04:59');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (112,'finance','store_url','Store Address can not be empty.','',1,'2020-06-04 14:18:02','2020-06-19 15:05:35');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (113,'finance','beneficiary_name','Beneficiary Name can not be empty.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (114,'finance','bank_name','Bank Name can not be empty','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (115,'finance','account_no','Account No. can not be empty','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (116,'finance','bank_address','Bank Address can not be empty','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (117,'finance','swift_code','Bank Identifier Code, please consult with the beneficiary bank.','',1,'2020-06-04 14:18:02','2020-06-19 15:06:11');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (118,'finance','not_agree','Must Agree to the aboce contract terms.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (119,'finance','country_empty','Country can not be empty','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (120,'finance','network_error','Something wrong with your connection, please try again later.','',1,'2020-06-04 14:18:02','2020-06-19 15:07:04');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (121,'promote','first_login','Please complete promote information first.','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (123,'appsettings','facebook_app_id_tip','You can find your App ID on your apps <a target=\"_blank\"; href=\"https://developers.facebook.com/apps\">settings page.</a>','',1,'2020-06-16 18:29:11','2020-06-16 18:39:40');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (124,'appsettings','facebook_system_user_access_token_tip','Please contact your Facebook account manager to receive your long term System User Access Token or refer to Facebook <a target=\"_blank\" href=\"https://developers.facebook.com/docs/audience-network/guides/reporting/system-user/\">documentation </a>.','',1,'2020-06-16 18:42:06','2020-06-16 18:42:06');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (125,'appsettings','unity_game_id_tip','From the <a target=\"_blank\" href=\"https://dashboard.unityads.unity3d.com/\">UnityAds dashboard</a>, choose your game. Your Game ID will be listed next to the platform.','',1,'2020-06-16 18:47:04','2020-06-16 18:47:04');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (126,'appsettings','vungle_app_id_tip','From the <a target=\"_blank\" href=\"https://dashboard.vungle.com/dashboard/accounts/details\">Vungle Details Dashboard</a>, select your application. On the next page, find the Vungle App ID in the Application Details column.','',1,'2020-06-16 18:48:27','2020-06-16 18:48:27');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (127,'appsettings','gdt_app_id_tip','From this <a target=\"_blank\" href=\"http://adnet.qq.com/medium/list\">Medium</a> page to get your App ID','',1,'2020-06-16 18:49:10','2020-06-16 18:49:10');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (128,'appsettings','admob_app_id_tip','From <a target=\"_blank\" href=\"https://apps.admob.com/?pli=1#account/settings:view\">the AdMob Monetize page</a>, select \"All Apps\" in the left sidebar, then choose your app. Click \"View setup instructions\" and copy the App ID displayed in the instructions. Make sure you use the same account as you do for the \"Grant Access\" button above otherwise the access will not be granted.','',1,'2020-06-16 18:56:31','2020-06-16 18:56:31');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (129,'appsettings','adcolony_app_id_tip','APP ID will be AdColony app UUID which is under \"Basic App Information\".','',1,'2020-06-16 18:59:08','2020-06-30 16:57:53');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (130,'appsettings','applovin_sdk_key_tip','From your <a target=\"_blank\" href=\"https://applovin.com/users/edit\">Account page</a>, choose \"Keys\" in the left sidebar, then select the SDK Key.','',1,'2020-06-16 18:59:47','2020-06-16 18:59:47');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (131,'appsettings','tapjoy_sdk_key_tip','This is available on the App Info tab under Settings -> App Settings on the Tapjoy Monetization Dashboard.','',1,'2020-06-16 19:00:53','2020-06-16 19:00:53');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (132,'appsettings','chartboost_app_id_tip','You can find your games App ID on its App Settings page on the <a target=\"_blank\" href=\"https://dashboard.chartboost.com/\">Chartboost dashboard</a>. See <a target=\"_blank\" href=\"https://answers.chartboost.com/hc/en-us/articles/201465075\">this Chartboost documentation for a screenshot.</a>','',1,'2020-06-16 19:01:30','2020-06-16 19:01:30');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (133,'appsettings','chartboost_app_signature_tip','You can find your games App ID on its App Settings page on the <a target=\"_blank\" href=\"https://dashboard.chartboost.com/\">Chartboost dashboard</a>. See <a target=\"_blank\" href=\"https://answers.chartboost.com/hc/en-us/articles/201465075\">this Chartboost documentation for a screenshot.</a>','',1,'2020-06-16 19:01:55','2020-06-16 19:01:55');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (134,'appsettings','ironsource_app_key_tip','From this <a target=\"_blank\" href=\"https://platform.ironsrc.com/partners/applications\">App Management</a> page to get your App Key','',1,'2020-06-16 19:02:49','2020-06-16 19:02:49');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (135,'account','admob_api_key_tip','To retrieve your API KEY, you must first create a designated project for your app on the <a target=\"_blank\" href=\"https://console.cloud.google.com/home\">Google Cloud Console</a>. For more steps, please visit <a target=\"_blank\" href=\"https://support.adtiming.com/hc/en-us/articles/360045557313-AdMob#adtiming-platform-configuration-0-4\">AdTiming Help Center</a>','',1,'2020-06-16 20:11:47','2020-08-13 18:07:27');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (136,'account','admob_client_id_tip','To retrieve your Client ID & Client Secret, go to <a target=\"_blank\" href=\"https://console.cloud.google.com/apis\"> Google’s API Manager </a>.','',1,'2020-06-16 20:15:11','2020-07-14 18:29:27');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (137,'account','admob_client_secrect_tip','To retrieve your Client ID & Client Secret, go to <a target=\"_blank\" href=\"https://console.cloud.google.com/apis\"> Google’s API Manager </a>.','',1,'2020-06-16 20:15:39','2020-07-14 18:29:36');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (138,'account','admob_refresh_token_tip','To retrieve your Refresh Token, go to the <a target=\"_blank\" href=\"https://developers.google.com/oauthplayground/#step1&scopes=https%3A//www.googleapis.com/auth/adwords&url=https%3A//&content_type=application/json&http_method=GET&useDefaultOauthCred=checked&oauthEndpointSelect=Google&oauthAuthEndpointValue=https%3A//accounts.google.com/o/oauth2/auth&oauthTokenEndpointValue=https%3A//www.googleapis.com/oauth2/v3/token&includeCredentials=unchecked&accessTokenType=bearer&autoRefreshToken=unchecked&accessType=offline&forceAprovalPrompt=checked&response_type=code\">OAuth 2.0 Playground</a>.','',1,'2020-06-16 20:16:05','2020-07-14 18:23:30');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (139,'account','admob_user_id_tip','From <a target=\"_blank\" href=\"https://apps.admob.com/?pli=1#account/settings:view\">the AdMob Monetize page</a>,Click the user avatar to get publisher id,Publisher ID like pub-xxxxxxxxxx','',1,'2020-06-16 20:16:43','2020-06-16 20:16:43');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (142,'account','admob_client_json_tip','From <a target=\"_blank\" href=\"https://console.developers.google.com/\">the Google Api Credentials page</a>,Download OAuth 2.0 Client json file and copy this file content to here','',1,'2020-06-16 20:20:06','2020-06-16 20:20:06');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (143,'account','admob_auth_url_tip','From <a target=\"_blank\" href=\"https://apps.admob.com/?pli=1#account/settings:view\">the Client ID for Web application page</a>, Copy this url to Authorized redirect URIs Users will be redirected to this path after they have authenticated with Google.','',1,'2020-06-16 20:20:34','2020-06-16 20:20:34');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (144,'account','unity_api_key_tip','You can retrieve the Monetization Stats API key from Unity Ads <a target=\"_blank\" href=\"https://dashboard.unityads.unity3d.com/\">Operate Dashboard</a>.','',1,'2020-06-16 20:21:39','2020-06-20 08:57:27');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (145,'account','vungle_reporting_api_key_tip','Go to the <a target=\"_blank\" href=\"https://publisher.vungle.com/account\">My Account</a> on the upper-right corner of the screen you will then see the Reporting API Key.','',1,'2020-06-16 20:22:25','2020-07-21 11:54:15');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (146,'account','adcolony_read_only_api_key_tip','Your key will be labeled as \"Read-Only API Key\" on <a target=\"_blank\" href=\"https://clients.adcolony.com/users/edit\">this page</a>','',1,'2020-06-16 20:23:06','2020-06-30 16:51:25');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (147,'account','applovin_report_key_tip','From your <a target=\"_blank\" href=\"https://applovin.com/users/edit\">Account page</a>, choose \"Keys\" in the left sidebar, then select the Report Key. If you do not see the Report Key field, email support@applovin.com and request your reporting key.','',1,'2020-06-16 20:23:42','2020-06-16 20:23:42');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (148,'account','mopub_api_key_tip','From the <a target=\"_blank\" href=\"https://app.mopub.com/reports/custom/\">Reports page</a>, check \"Enable data access through API\". Then click the \"View API Access Details\" link to reveal your API Key.','',1,'2020-06-16 20:24:16','2020-06-16 20:24:16');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (149,'account','mopub_inventory_report_id_tip','From the <a target=\"_blank\" href=\"https://app.mopub.com/reports/custom/\">Reports page</a>, click the \"View API Access Details\" link to reveal your Inventory Report ID.','',1,'2020-06-16 20:24:47','2020-06-16 20:25:35');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (150,'account','tapjoy_publisher_reporting_api_key_tip','This is available on the App Info tab under Settings -> App Settings on the Tapjoy Monetization Dashboard.','',1,'2020-06-16 20:25:57','2020-06-16 20:25:57');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (151,'account','tapjoy_ad_reporting_api_key_tip','This is available on the App Info tab under Settings -> App Settings on the Tapjoy Monetization Dashboard.','',1,'2020-06-16 20:26:52','2020-06-16 20:26:52');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (152,'account','chartboost_user_id_tip','From the <a target=\"_blank\" href=\"https://dashboard.chartboost.com/tools/api\">API Explorer Page</a>, select the User ID','',1,'2020-06-16 20:27:25','2020-06-16 20:27:25');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (153,'account','chartboost_user_signature_tip','From the <a target=\"_blank\" href=\"https://dashboard.chartboost.com/tools/api\">API Explorer Page</a>, select the User Signature.','',1,'2020-06-16 20:27:51','2020-06-16 20:27:51');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (154,'account','ironsource_user_name_tip','From <a target=\"_blank\" href=\"https://platform.ironsrc.com/partners/account/generalInfo\">ironSource My Account</a> page,selected User Info Tab to get your User Name','',1,'2020-06-16 20:28:40','2020-06-16 20:28:40');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (155,'account','ironsource_secret_key_tip','From <a target=\"_blank\" href=\"https://platform.ironsrc.com/partners/account/apiDetails\">ironSource My Account</a> page,selected API Tab to get your Secret Key','',1,'2020-06-16 20:29:03','2020-06-16 20:29:03');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (156,'mediation','already_existed_hb','Every ad network has ONE bidding id only.','',1,'2020-06-18 14:20:04','2020-06-18 14:20:04');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (157,'pubapp','app_id_tip','','App ID商店查询表单提示，为空不显示',1,'2020-06-18 17:43:09','2020-06-18 17:44:18');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (158,'pubapp','app_name_tip','','',1,'2020-06-18 18:06:34','2020-06-18 18:06:34');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (159,'pubapp','platform_tip','','',1,'2020-06-18 18:06:53','2020-06-18 18:06:53');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (160,'placement','name_tip','','',1,'2020-06-18 18:18:35','2020-06-18 18:18:35');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (161,'placement','callback_url_tip','The HTTP GET method called to your server in order to inform you to credit a user.','',1,'2020-06-19 11:06:37','2020-07-29 15:34:14');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (162,'placement','frequency_tip','Input the time interval you want to limit between ads for the placement.','',1,'2020-06-19 11:07:09','2020-07-29 15:37:50');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (163,'placement','pacing_tip','Input the number of ads you want to limit for the placement.','',1,'2020-06-19 11:07:35','2020-07-29 15:37:22');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (164,'account','admob_publisher_id','<b>AdMob Publisher ID</b>\r\n<br>It will be filled automatically after you finish the settings.','',1,'2020-06-04 14:18:02','2020-07-29 15:28:05');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (165,'account','unity_org_id_tip','Organization core ID can be retrieved from the Settings tab of the Unity Ads Operate Dashboard.','',1,'2020-06-04 14:18:02','2020-07-31 10:02:18');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (170,'account','pangle_user_id_tip','','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (171,'account','pangle_secret_key_tip','','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (172,'appsettings','pangle_app_id_tip','','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (173,'appsettings','mintegral_app_id_tip','','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (174,'appsettings','mintegral_app_key_tip','','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (175,'account','mintegral_report_api_skey_tip','','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (176,'account','mintegral_report_api_secret_tip','','',1,'2020-06-04 14:18:02','2020-06-04 14:18:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (177,'appsettings','dev_key_tip','','',1,'2020-06-04 14:18:02','2020-06-19 12:05:02');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (178,'mediation','rule_name_tip','','',1,'2020-07-14 16:45:24','2020-07-29 15:00:34');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (179,'mediation','optimized_type_tip','Select the optimized type of this mediation rule.</br>\r\n<br><b>Auto</b>\r\n<br>The instances are prioritized using AdTiming’s dynamic meditation algorithm, which adjusts the waterfall per session and gives each instance a chance to deliver in different positions to improve the eCPM.</br>\r\n<br><b>Manual</b>\r\n<br>The instances will deliver according to the order you place them.</br>','',1,'2020-07-14 16:56:53','2020-07-29 22:10:30');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (180,'mediation','regions_tip','Select the regions you want to include when targeting this mediation rule.','',1,'2020-07-14 16:59:24','2020-07-29 15:15:30');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (181,'mediation','frequency_tip','Input the number of times the ads were shown when targeting this mediation rule.','',1,'2020-07-14 17:05:34','2020-07-29 15:17:57');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (182,'mediation','gender_tip','Select the gender you want to include when targeting this mediation rule\r\n<br>Left it empty means for all genders.','',1,'2020-07-14 17:08:12','2020-07-29 15:19:54');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (183,'mediation','iap_tip','Input the range of users IAP you want to include when targeting this mediation rule.','',1,'2020-07-14 17:15:16','2020-07-29 15:21:56');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (184,'mediation','age_tip','Input the range of users age you want to include when targeting this mediation rule.','',1,'2020-07-14 17:27:05','2020-07-29 15:21:26');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (185,'mediation','contype_tip','Select the connection type you want to include when targeting this mediation rule.','',1,'2020-07-14 17:30:23','2020-07-29 15:22:30');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (186,'mediation','model_type_tip','Select the device type you want to include when targeting this mediation rule.','',1,'2020-07-14 17:30:38','2020-07-29 15:22:56');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (187,'mediation','brand_tip','Select the device brand you want to include or exclude when targeting this mediation rule.','',1,'2020-07-14 17:31:00','2020-07-29 15:23:10');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (188,'mediation','model_tip','Select the device model you want to include or exclude when targeting this mediation rule.','',1,'2020-07-14 17:31:45','2020-07-29 15:23:19');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (189,'abtest','name_tip','','',1,'2020-07-14 17:49:06','2020-07-29 15:26:16');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (190,'abtest','placement_tip','Select the placement you want to start this new a/b test on.','',1,'2020-07-14 17:50:24','2020-07-29 15:24:23');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (191,'abtest','traffic_tip','','',1,'2020-07-14 18:13:55','2020-07-29 15:26:09');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (192,'report','p_day','View performance by Date','',1,'2020-07-30 17:27:21','2020-07-30 17:27:21');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (193,'report','p_hour','View performance by Hour','',1,'2020-07-30 17:28:08','2020-07-30 17:28:08');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (194,'report','p_adtype','View performance by ad type (e.g., Banner, Interstitial).','',1,'2020-07-30 17:28:54','2020-07-30 17:28:54');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (195,'report','p_country','View performance broken down by the region of visitors that have viewed ads on your app.','',1,'2020-07-30 17:29:31','2020-07-30 17:29:31');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (196,'report','p_placement','View performance for individual ad placements.','',1,'2020-07-30 17:30:07','2020-07-30 17:30:07');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (197,'report','p_adn','View performance by ad network','',1,'2020-07-30 17:30:35','2020-07-30 17:30:35');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (198,'report','p_app','View performance by app.','',1,'2020-07-30 17:30:56','2020-07-30 17:30:56');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (199,'report','p_request','Breakdown by Instance or Ad Network: The number of requests your app has made to each ad network recorded by AdTiming SDK \r\nBreakdown by Placement or above: The number of times your app has requested an ad through AdTIming Mediation recorded by AdTiming SDK. Each mediation request counted here may represent multiple requests sent to different ad networks.','',1,'2020-07-30 17:31:22','2020-08-07 16:50:48');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (200,'report','p_api_request','The number of times your app has requested an ad recorded by ad network','',1,'2020-07-30 17:31:55','2020-07-30 17:31:55');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (201,'report','p_instance','View performance across the unique instances of each ad network that appear in this report.','',1,'2020-07-30 17:32:33','2020-07-30 17:32:33');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (202,'report','p_scenes','View performance for individual scenes','',1,'2020-07-30 17:33:40','2020-07-30 17:33:40');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (203,'report','p_ctr','The number of clicks compared to the number of impressions recorded by AdTiming SDK. CTR is calculated as clicks divided by impressions.','',1,'2020-07-30 17:35:24','2020-07-30 17:35:24');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (204,'report','p_api_ctr','The number of clicks compared to the number of impressions recorded by ad network. API CTR is calculated as API clicks divided by API impressions.','',1,'2020-07-30 17:36:52','2020-07-30 17:36:52');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (205,'report','p_fills','The number of times the ad network returns an ad in response to an ad request recorded by AdTiming SDK. ','',1,'2020-07-30 17:37:36','2020-07-30 17:37:36');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (206,'report','p_api_fills','The number of times the ad network returns an ad in response to an ad request recorded by ad network. ','',1,'2020-07-30 17:38:42','2020-07-30 17:38:42');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (207,'report','p_fillrate','The number of ads that ad network returns compared to the number of ads requested recorded by AdTiming SDK. Fill rate is calculated as fills divided by requests.','',1,'2020-07-30 17:39:20','2020-07-30 17:39:20');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (208,'report','p_api_fillrate','The number of ads that ad network returns compared to the number of ads requested recorded by ad network. API Fill rate is calculated as API fills divided by API requests.','',1,'2020-07-30 17:39:43','2020-07-30 17:39:43');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (209,'report','p_api_click','The number of clicks on your ads recorded by ad network','',1,'2020-07-30 17:40:15','2020-07-30 17:40:15');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (210,'report','p_click','The number of clicks on your ads recorded by AdTiming SDK.','',1,'2020-07-30 17:40:41','2020-07-30 17:40:41');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (211,'report','p_api_impr','Total number of times the ad is shown recorded by ad network.','',1,'2020-07-30 17:41:03','2020-07-30 17:41:13');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (212,'report','p_impr','Total number of times the ad is shown recorded by AdTiming SDK.','',1,'2020-07-30 17:41:35','2020-07-30 17:41:35');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (213,'report','p_cost','The total amount of revenue generated','',1,'2020-07-30 17:41:59','2020-07-30 17:41:59');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (214,'report','p_ecpm','Effective cost per thousand Impressions, calculated as (Revenue / API Impressions) * 1000','',1,'2020-07-30 17:42:20','2020-07-30 18:51:32');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (215,'report','p_a_check','The number of times an ad source is asked whether it is ready to show an ad','',1,'2020-07-30 17:43:20','2020-07-30 17:43:20');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (216,'report','p_a_response','The number of times an ad source had an ad available to show at the time of the request','',1,'2020-07-30 17:43:53','2020-07-30 17:43:53');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (217,'report','p_a_rate','The rate at which an ad source had an ad available when an ad was requested','',1,'2020-07-30 17:44:33','2020-07-30 17:44:33');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (218,'report','p_video_completions','The amount of Video Completions','',1,'2020-07-30 17:44:58','2020-07-30 17:44:58');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (219,'report','p_video_start','The amount of Video Start','',1,'2020-07-30 17:45:30','2020-07-30 17:45:30');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (220,'report','i_day','View performance by Date','',1,'2020-07-30 17:27:21','2020-07-30 17:27:21');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (221,'report','i_hour','View performance by Hour','',1,'2020-07-30 17:28:08','2020-07-30 17:28:08');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (222,'report','i_adtype','View performance by ad type (e.g., Banner, Interstitial).','',1,'2020-07-30 17:28:54','2020-07-30 17:28:54');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (223,'report','i_country','View performance broken down by the region of visitors that have viewed ads on your app.','',1,'2020-07-30 17:29:31','2020-07-30 17:29:31');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (224,'report','i_placement','View performance for individual ad placements.','',1,'2020-07-30 17:30:07','2020-07-30 17:30:07');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (225,'report','i_bidsource','View performance by bid source.','',1,'2020-07-30 17:30:35','2020-07-30 17:30:35');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (226,'report','i_app','View performance by app.','',1,'2020-07-30 17:30:56','2020-07-30 17:30:56');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (227,'report','i_instance','View performance across the unique instances of each ad network that appear in this report.','',1,'2020-07-30 17:32:33','2020-07-30 17:32:33');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (228,'report','i_request','The number of requests made to an In-app Bidding ad network.','',1,'2020-07-30 17:40:41','2020-07-30 17:40:41');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (229,'report','i_response','The number of bids submitted by the ad network that participated in In-app Bidding auctions. ','',1,'2020-07-30 17:41:03','2020-07-30 17:41:13');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (230,'report','i_bidrate','The percentage of bids that participated in In-app Bidding auctions. ','',1,'2020-07-30 17:43:20','2020-07-30 17:43:20');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (231,'report','i_win','The number of bids that won in an request.','',1,'2020-07-30 17:43:53','2020-07-30 17:43:53');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (232,'report','i_winrate','The percentage of bids that won an In-app Bidding auction.','',1,'2020-07-30 17:44:33','2020-07-30 17:44:33');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (233,'report','i_impr','Total number of times the ad is shown. ','',1,'2020-07-30 17:41:35','2020-07-30 17:41:35');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (234,'report','i_cost','The total amount of revenue generated','',1,'2020-07-30 17:41:59','2020-07-30 17:41:59');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (235,'report','i_ecpm','Effective cost per thousand Impressions; calculated as (Revenue / Impressions) * 1000','',1,'2020-07-30 17:42:20','2020-07-30 18:51:32');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (236,'placement','brand_tip','','',1,'2020-06-19 11:07:09','2020-08-12 11:52:22');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (237,'placement','model_tip','','',1,'2020-06-19 11:07:09','2020-08-12 11:52:25');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (238,'mediation','fanout_tip','','',1,'2020-07-14 17:31:45','2020-08-12 14:19:36');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (239,'mediation','batchsize_tip','Batch Size','',1,'2020-07-14 17:31:45','2020-07-29 15:23:19');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (240,'mediation','preload_tip','Preload Timeout(s)','',1,'2020-07-14 17:31:45','2020-07-29 15:23:19');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (241,'mediation','poolsize_tip','Pool Size','',1,'2020-07-14 17:31:45','2020-07-29 15:23:19');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (242,'mediation','inventory_interval_tip','Inventory Interval','',1,'2020-07-14 17:31:45','2020-07-29 15:23:19');
INSERT INTO open_mediation.om_message_dict (`id`,`page`,`msg_key`,`value`,`name`,`status`,`create_time`,`lastmodify`) VALUES (243,'mediation','max_concurrency_tip','Max Concurrency','',1,'2020-07-14 17:31:45','2020-08-12 14:20:45');

CREATE TABLE `report_adnetwork_account_publisher` (
  `publisher_id` int(11) NOT NULL DEFAULT '0' COMMENT 'publisher ID',
  `report_account_id` int(11) NOT NULL DEFAULT '0' COMMENT 'AdNetwork账号ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`publisher_id`,`report_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='adnetwork账号和publisher关系表';

insert into open_mediation.report_adnetwork_account_publisher (SELECT
    distinct account.publisher_id, account.id, now()
FROM
    open_mediation.om_adnetwork_app AS app
        LEFT JOIN
    open_mediation.report_adnetwork_account AS account ON app.report_account_id = account.id
WHERE
    account.publisher_id > 0);

2020-08-12
 ALTER TABLE `open_mediation`.`om_publisher_app`
 DROP INDEX `app_id` ;
