
INSERT INTO users (last_name, name, phone_number, email_address, password, deleted) values
    ('Filipovic','Dragana','06245789631', 'dragana@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false);
INSERT INTO patient (users, height, weight, date_of_birth, number_of_miscarriage, jmbg, addict, alcoholic, genetic_anomalies, smoker) 
values (1, 165, 55, '1983-12-24T08:00', 0, 12345678912345, false, false, false, false);

INSERT INTO illness (name, deleted) values ('Hipertenzija', false);
INSERT INTO illness_symptoms (id, symptom) values (1, 'HIGH_BLOOD_PRESSURE');

/*INSERT INTO patient_illnesses(patient_users, illnesses_id) values (1, 1);*/

INSERT INTO birth (weight, miscarriage, gestational_age, complications, c_section, deleted) values (4.5, false, 37, false, false, false);

INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted) values ('2022-03-03T13:34:00.000', 1, 1, false, false, false);

INSERT INTO pregnancy (start_date, number_of_pregnancies, patient_users, high_risk_pregnancy, premature_labor,  deleted, birth_id) values ('2020-12-17T13:34:00.000', 1, 1, false, false, false, 1);
