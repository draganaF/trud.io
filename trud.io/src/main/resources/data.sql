
INSERT INTO users (last_name, name, phone_number, email_address, password, deleted, role) values
    ('Filipovic','Dragana','06245789631', 'dragana@gmail.com', '123', false, 1);
INSERT INTO patient (users, height, weight, date_of_birth, number_of_miscarriage, jmbg, addict, alcoholic, genetic_anomalies, smoker) 
values (1, 165, 55, '1972-12-24T08:00', 2, 12345678912345, false, false, false, false);

INSERT INTO users (last_name, name, phone_number, email_address, password, deleted, role) values
    ('Jevtic','Jovana','06245759631', 'jovanatrudnica@gmail.com', '123', false, 0 );
INSERT INTO patient (users, height, weight, date_of_birth, number_of_miscarriage, jmbg, addict, alcoholic, genetic_anomalies, smoker) 
values (2, 175, 63, '1983-06-22T08:00', 0, 2206983654123, false, false, false, false);

INSERT INTO users (last_name, name, phone_number, email_address, password, deleted, role) values 
	('Jovana', 'Jevtic', '0655421846', 'jovana@gmail.com', '123', false, 0);	
INSERT INTO doctor(users) values (3);

INSERT INTO users (last_name, name, phone_number, email_address, password, deleted, role) values
	('Nikolina', 'Tosic', '12390187421', 'pahulja@gmail.com', '123', false, 2);
INSERT INTO nurse(users) values (4);

INSERT INTO users (last_name, name, phone_number, email_address, password, deleted, role) values
    ('Adjelic','Andjela','06241789631', 'andjela@gmail.com', '123', false, 1);
INSERT INTO patient (users, height, weight, date_of_birth, number_of_miscarriage, jmbg, addict, alcoholic, genetic_anomalies, smoker) 
values (5, 165, 55, '1982-12-24T08:00', 0, 1478529632154, false, false, false, false);

INSERT INTO users (last_name, name, phone_number, email_address, password, deleted, role) values
    ('Savic','Sanja','06241782331', 'sanja@gmail.com', '123', false, 1);
INSERT INTO patient (users, height, weight, date_of_birth, number_of_miscarriage, jmbg, addict, alcoholic, genetic_anomalies, smoker) 
values (6, 165, 55, '1992-12-24T08:00', 0, 96321478541236, false, false, false, false);


INSERT INTO illness (name, deleted) values ('Dijabetes', false);
INSERT INTO illness (name, deleted) values ('Hipertenzija', false);
INSERT INTO illness_symptoms (id, symptom) values (1, 'HIGH_BLOOD_PRESSURE');

INSERT INTO illness (name, deleted) values ('Trudnicki dijabetes', false);
INSERT INTO illness_symptoms (id, symptom) values (2, 'BLURRY_VISION');
INSERT INTO illness_symptoms (id, symptom) values (2, 'FATIGUE');
INSERT INTO illness_symptoms (id, symptom) values (2, 'NAUSEA');
INSERT INTO illness_symptoms (id, symptom) values (2, 'VOMITING');
INSERT INTO illness_symptoms (id, symptom) values (2, 'FREQUENT_URINATION');
INSERT INTO illness_symptoms (id, symptom) values (2, 'UNUSUAL_THIRST');

INSERT INTO birth (weight, miscarriage, gestational_age, complications, c_section, deleted, chromosomal_disorder, abortion, birth_date_time) 
values (4.5, false, 37, false, false, false, 'DOWN', false, '2019-09-15T13:34:00.000');
INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted, birth_id) 
values ('2019-12-17T13:34:00.000', 1, 1, true, true, false, 1);

INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted) 
values ('2022-03-20T13:34:00.000', 1, 1, true, true, false);

INSERT INTO birth (weight, miscarriage, gestational_age, complications, c_section, deleted, chromosomal_disorder, abortion, birth_date_time) 
values (3.5, false, 37, false, false, false, 'NO_DISORDER', false,'2021-11-15T13:34:00.000' );
INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted, birth_id) 
values ('2021-02-12T13:34:00.000', 1, 5, false, false, false, 2);

INSERT INTO birth (weight, miscarriage, gestational_age, complications, c_section, deleted, chromosomal_disorder, abortion,birth_date_time) 
values (3.1, false, 35, false, false, false, 'PATAU', false, '2021-01-15T13:34:00.000');
INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted, birth_id) 
values ('2020-03-12T13:34:00.000', 1, 5, false, false, false, 3);

INSERT INTO birth (weight, miscarriage, gestational_age, complications, c_section, deleted, chromosomal_disorder, abortion, birth_date_time) 
values (2.9, false, 38, false, false, false, 'NO_DISORDER', false, '2022-01-01T13:34:00.000');
INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted, birth_id) 
values ('2021-03-12T13:34:00.000', 1, 6, false, false, false, 4);

INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted) 
values ('2022-02-27T13:34:00.000', 1, 5, true, true, false);
--INSERT INTO birth (weight, miscarriage, gestational_age, complications, c_section, deleted) values (4.5, false, 37, false, false, false);


INSERT INTO pregnancy_symptoms (id, symptom) values (2, 'SWELLING');
INSERT INTO pregnancy_symptoms (id, symptom) values (2, 'WEIGHT_GAIN');
INSERT INTO pregnancy_symptoms (id, symptom) values (2, 'NAUSEA');
INSERT INTO pregnancy_symptoms (id, symptom) values (2, 'VOMITING');
INSERT INTO pregnancy_symptoms (id, symptom) values (1, 'FREQUENT_URINATION');
INSERT INTO pregnancy_symptoms (id, symptom) values (1, 'UNUSUAL_THIRST');
INSERT INTO pregnancy_symptoms (id, symptom) values (3, 'HIGH_BLOOD_PRESSURE');
INSERT INTO pregnancy_symptoms (id, symptom) values (3, 'FATIGUE');
INSERT INTO pregnancy_symptoms (id, symptom) values (3, 'SHORTNESS_OF_BREATH');
INSERT INTO pregnancy_symptoms (id, symptom) values (4, 'VOMITING');
INSERT INTO pregnancy_symptoms (id, symptom) values (4, 'NAUSEA');
INSERT INTO pregnancy_symptoms (id, symptom) values (4, 'PRESSURE_IN_LOWER_BELLY');

INSERT INTO pregnancy_illnesses (pregnancy_id, illnesses_id) values (2, 1);
INSERT INTO pregnancy_illnesses (pregnancy_id, illnesses_id) values (4, 3);
INSERT INTO pregnancy_illnesses (pregnancy_id, illnesses_id) values (5, 3);

INSERT INTO therapy(medicine, report, deleted) values ('Dijeta', 'Stroga dijeta', false);
INSERT INTO patient_therapies (patient_users, therapies_id) values (1, 1);
INSERT INTO therapy(medicine, report, deleted) values ('Dijeta', 'Stroga dijeta', false);
INSERT INTO patient_therapies (patient_users, therapies_id) values (5, 2);

INSERT INTO ogtt_test(primary_sampling, result, deleted, first_blood_sampling, second_blood_sampling, third_blood_sampling, fourth_blood_sampling, date) 
values (150, 'EXTENDED_OGTT', false, 0, 0, 0, 0, '2022-05-12T13:34:00.000');
INSERT INTO pregnancy_ogtt_tests(pregnancy_id, ogtt_tests_id) values (2, 1);

INSERT INTO ogtt_test(primary_sampling, result, deleted, first_blood_sampling, second_blood_sampling, third_blood_sampling, fourth_blood_sampling, date)
values (80, 'NEGATIVE', false, 0, 0, 0, 0, '2020-04-20T10:30:00.000');
INSERT INTO pregnancy_ogtt_tests(pregnancy_id, ogtt_tests_id) values (1, 2);

INSERT INTO ogtt_test(primary_sampling, result, deleted, first_blood_sampling, second_blood_sampling, third_blood_sampling, fourth_blood_sampling, date)
values (160, 'POSITIVE', false, 0, 0, 0, 0, '2020-04-20T10:30:00.000');
INSERT INTO pregnancy_ogtt_tests(pregnancy_id, ogtt_tests_id) values (4, 3);

INSERT INTO ogtt_test(primary_sampling, result, deleted, first_blood_sampling, second_blood_sampling, third_blood_sampling, fourth_blood_sampling, date)
values (0, 'NOT_PROCESSED', false, 0, 0, 0, 0, '2022-06-01T10:30:30.000');
INSERT INTO pregnancy_ogtt_tests(pregnancy_id, ogtt_tests_id) values (6, 4);


INSERT INTO appointment (date, blood_pressure_upper, blood_pressure_lower, report, is_done, weight, patient_users, pregnancy_id, deleted) 
values ('2022-06-17T13:45:00.000', 0, 0, '', false, 0, 1, 2, false);
	
INSERT INTO appointment (date, blood_pressure_upper, blood_pressure_lower, report, is_done, weight, patient_users, pregnancy_id, deleted) 
values ('2022-06-27T13:45:00.000', 0, 0, '', false, 0, 1, 2, false);




INSERT INTO ctg(acceleration_presence, bradycardia, contractions, fetal_hart_rate, fhr_status, result, tachycardia,variabilty_status, varibilty, deleted)
values(true, true, 18, 75.3312, 2, 2, false, 0, 7.2, false );

INSERT INTO ctg(acceleration_presence, bradycardia, contractions, fetal_hart_rate, fhr_status, result, tachycardia,variabilty_status, varibilty, deleted)
values(true, true, 18, 75.3312, 2, 2, false, 1, 5.2, false );

INSERT INTO ctg(acceleration_presence, bradycardia, contractions, fetal_hart_rate, fhr_status, result, tachycardia,variabilty_status, varibilty, deleted)
values(true, false, 12, 113.3312, 0, 0, false, 0, 10.3, false );

INSERT INTO ctg(acceleration_presence, bradycardia, contractions, fetal_hart_rate, fhr_status, result, tachycardia,variabilty_status, varibilty, deleted)
values(true, false, 30, 167.3312, 1, 2, true, 1, 25.9, false );

INSERT INTO pregnancy_ctg(pregnancy_id, ctg_id) values (1, 1);
INSERT INTO pregnancy_ctg(pregnancy_id, ctg_id) values (2, 2);
INSERT INTO pregnancy_ctg(pregnancy_id, ctg_id) values (3, 3);
INSERT INTO pregnancy_ctg(pregnancy_id, ctg_id) values (4, 4);


INSERT INTO age_risk (age, risk, trisomy, deleted) values (18, 1210, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (18, 3150, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (18, 7945, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (19, 1205, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (19, 3145, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (19, 7930, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (20, 1200, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (20, 3135, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (20, 7905, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (21, 1185, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (21, 3125, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (21, 7875, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (22, 1165, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (22, 3110, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (22, 7835, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (23, 1205, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (23, 3090, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (23, 7780, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (24, 1120, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (24, 3060, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (24, 7700, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (25, 1085, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (25, 3020, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (25, 7590, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (26, 1030, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (26, 2970, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (26, 7445, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (27, 975, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (27, 2900, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (27, 7250, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (28, 900, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (28, 2805, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (28, 6990, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (29, 825, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (29, 2680, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (29, 6655, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (30, 730, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (30, 2525, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (30, 6225, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (31, 630, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (31, 2330, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (31, 5700, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (32, 535, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (32, 2095, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (32, 5085, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (33, 430, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (33, 1825, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (33, 4400, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (34, 345, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (34, 1535, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (34, 3680, 'Trisomy13', false);

INSERT INTO age_risk (age, risk, trisomy, deleted) values (35, 260, 'Trisomy21', false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (35, 1235, 'Trisomy18',  false);
INSERT INTO age_risk (age, risk, trisomy, deleted) values (35, 2975, 'Trisomy13', false);


INSERT INTO weekly_parameters (week, median_afp, median_hcg, median_inhibina, median_pappa, median_ue3, deleted) values (12, 0, 48.0, 0 ,23.77, 2.29,false);
INSERT INTO weekly_parameters (week, median_afp, median_hcg, median_inhibina, median_pappa, median_ue3, deleted) values (13, 0, 40.0, 0 ,25.11, 2.67,false);
INSERT INTO weekly_parameters (week, median_afp, median_hcg, median_inhibina, median_pappa, median_ue3, deleted) values (14, 23.7, 39.0, 41.4 ,26.45, 2.29,false);
INSERT INTO weekly_parameters (week, median_afp, median_hcg, median_inhibina, median_pappa, median_ue3, deleted) values (15, 24.8, 31.0, 60.8 ,27.79, 2.67,false);
INSERT INTO weekly_parameters (week, median_afp, median_hcg, median_inhibina, median_pappa, median_ue3, deleted) values (16, 30.5, 27.0, 125.3 ,29.13, 3.80,false);
INSERT INTO weekly_parameters (week, median_afp, median_hcg, median_inhibina, median_pappa, median_ue3, deleted) values (17, 36.0, 20.5, 205 ,20.3, 4.68,false);
INSERT INTO weekly_parameters (week, median_afp, median_hcg, median_inhibina, median_pappa, median_ue3, deleted) values (18, 41.5, 16.1 ,360 ,20.44, 6.00,false);
INSERT INTO weekly_parameters (week, median_afp, median_hcg, median_inhibina, median_pappa, median_ue3, deleted) values (19, 45.3, 14.6, 500 ,33.15, 7.05,false);

