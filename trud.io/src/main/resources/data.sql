
INSERT INTO users (last_name, name, phone_number, email_address, password, deleted, role) values
    ('Filipovic','Dragana','06245789631', 'dragana@gmail.com', '123', false, 1);
INSERT INTO patient (users, height, weight, date_of_birth, number_of_miscarriage, jmbg, addict, alcoholic, genetic_anomalies, smoker) 
values (1, 165, 55, '1972-12-24T08:00', 2, 12345678912345, false, false, false, false);

INSERT INTO users (last_name, name, phone_number, email_address, password, deleted) values
    ('Jevtic','Jovana','06245759631', 'jovana@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false);
INSERT INTO patient (users, height, weight, date_of_birth, number_of_miscarriage, jmbg, addict, alcoholic, genetic_anomalies, smoker) 
values (2, 175, 63, '1983-06-22T08:00', 0, 2206983654123, false, false, false, false);


INSERT INTO illness (name, deleted) values ('Diabetes', false);
INSERT INTO illness (name, deleted) values ('Hipertenzija', false);
INSERT INTO illness_symptoms (id, symptom) values (1, 'HIGH_BLOOD_PRESSURE');

INSERT INTO illness (name, deleted) values ('Trudnicki dijabetes', false);
INSERT INTO illness_symptoms (id, symptom) values (2, 'BLURRY_VISION');
INSERT INTO illness_symptoms (id, symptom) values (2, 'FATIGUE');
INSERT INTO illness_symptoms (id, symptom) values (2, 'NAUSEA');
INSERT INTO illness_symptoms (id, symptom) values (2, 'VOMITING');
INSERT INTO illness_symptoms (id, symptom) values (2, 'FREQUENT_URINATION');
INSERT INTO illness_symptoms (id, symptom) values (2, 'UNUSUAL_THIRST');

INSERT INTO birth (weight, miscarriage, gestational_age, complications, c_section, deleted, chromosomal_disorder) values (4.5, false, 37, false, false, false, 'DOWN');

INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted) values ('2022-03-11T13:34:00.000', 1, 1, false, false, false);



--INSERT INTO birth (weight, miscarriage, gestational_age, complications, c_section, deleted) values (4.5, false, 37, false, false, false);


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

INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted, birth_id) values ('2019-12-17T13:34:00.000', 1, 1, false, false, false, 1);

INSERT INTO pregnancy_symptoms (id, symptom) values (2, 'SWELLING');
INSERT INTO pregnancy_symptoms (id, symptom) values (2, 'WEIGHT_GAIN');
INSERT INTO pregnancy_symptoms (id, symptom) values (2, 'NAUSEA');
INSERT INTO pregnancy_symptoms (id, symptom) values (2, 'VOMITING');
INSERT INTO pregnancy_symptoms (id, symptom) values (1, 'FREQUENT_URINATION');
INSERT INTO pregnancy_symptoms (id, symptom) values (1, 'UNUSUAL_THIRST');

INSERT INTO pregnancy_illnesses (pregnancy_id, illnesses_id) values (1, 1);

INSERT INTO appointment (date, blood_pressure_upper, blood_pressure_lower, report, is_done, weight, patient_users, pregnancy_id, deleted) values ('2022-06-17T13:45:00.000', 0, 0, '', false, 0, 1, 1, false);
	
INSERT INTO appointment (date, blood_pressure_upper, blood_pressure_lower, report, is_done, weight, patient_users, pregnancy_id, deleted) values ('2022-06-27T13:45:00.000', 0, 0, '', false, 0, 1, 1, false);

INSERT INTO ogtt_test(primary_sampling, result, deleted, first_blood_sampling, second_blood_sampling, third_blood_sampling, fourth_blood_sampling, date) values (150, 'EXTENDED_OGTT', false, 0, 0, 0, 0, '2022-04-12T13:34:00.000');

INSERT INTO pregnancy_ogtt_tests(pregnancy_id, ogtt_tests_id) values (1, 1);

