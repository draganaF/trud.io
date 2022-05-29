INSERT INTO users (last_name, name, phone_number, email_address, password, deleted) values
    ('Filipovic','Dragana','06245789631', 'dragana@gmail.com', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', false);
INSERT INTO patient (users, height, weight, date_of_birth, number_of_miscarriage, jmbg, addict, alcoholic, diabetic, genetic_anomalies, problem_high_blood_pressure, problem_with_kidneys, smoker) 
values (1, 165, 55, '2008-12-24T08:00', 0, 12345678912345, false, false, false, false, false, false, false);