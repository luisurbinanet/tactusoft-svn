-- ansrvsap2.affinity.net:8001

SET SQL_SAFE_UPDATES=0;
update crm_parameter
set text_value = replace(text_value,'192.168.1.210:8000','ansrvsap2.affinity.net:8001');

delete from crm_doctor_schedule
WHERE id > 97;


LOAD DATA LOCAL INFILE 'C:/Temp/crm_doctor_schedule.csv'
INTO TABLE crm_doctor_schedule
FIELDS TERMINATED BY ';';

create or replace view vw_appointment as
select a.id, 
		a.code, 
		a.start_appointment_date,
		a.end_appointment_date,
		a.state,
		b.id pat_id,
		b.doc pat_code,
		b.code_sap pat_code_sap,
		b.surnames pat_surnames, 
		b.firstnames pat_firstnames,
		b.phone_number pat_phone_number,
		b.cell_number pat_cell_number,
		c.id prc_det_id,
		c.name prc_det_name,
		d.id branch_id,
		d.code branch_code,
		d.name branch_name,
		d.society branch_society,
		e.id doctor_id,
		e.code doctor_code,
		e.names doctor_names,
		f.id user_create_id,
		f.username user_create_code,
		f.names user_create_names,
		f.surnames user_create_surnames,
		a.date_create,
		g.id user_modified_id,
		g.username user_modified_code,
		g.names user_modified_names,
		g.surnames user_modified_surnames,
		a.date_modified,
		h.id user_checked_id,
		h.username user_checked_code,
		h.names user_checked_names,
		h.surnames user_checked_surnames,
		a.date_checked,
		i.id user_canceled_id,
		i.username user_canceled_code,
		i.names user_canceled_names,
		i.surnames user_canceled_surnames,
		a.date_canceled
from crm_appointment a join crm_patient b on a.id_patient = b.id
join crm_procedure_detail c on a.id_procedure_detail = c.id
join crm_branch d on a.id_branch = d.id
join crm_doctor e on a.id_doctor = e.id
join crm_user f on a.id_user_create = f.id
left join crm_user g on a.id_user_modified = g.id
left join crm_user h on a.id_user_checked = h.id
left join crm_user i on a.id_user_canceled = i.id;
