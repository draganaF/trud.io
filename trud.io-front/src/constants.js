export const Roles = {
  ROLE_PATIENT: "PATIENT",
  ROLE_DOCTOR: "DOCTOR",
  ROLE_NURSE: "NURSE"
}

export const patientSymptoms = [
    {
        value: 'SWELLING',
        label: 'Oticanje'
      },
      {
        value: 'WEIGHT_GAIN',
        label: 'Dobijanje na težini'
      },
      {
        value: 'SEVERE_HEADACHES',
        label: 'Jake glavobolje'
      },
      {
        value: 'SHORTNESS_OF_BREATH',
        label: 'Teškoće sa disanjem'
      },
        {
        value: 'SEIZURES',
        label: 'Napadi'
      },
        {
        value: 'LOSS_OF_CONSCIOUSNESS',
        label: 'Gubitak svesti'
      },
       {
        value: 'NAUSEA',
        label: 'Mučnina'
      },
       {
        value: 'VOMITING',
        label: 'Povraćanje'
      },
       {
        value: 'HIGH_BLOOD_PRESSURE',
        label: 'Visok krvni pritisak'
      },
      {
        value: 'PROTEINURIA',
        label: 'Proteinurija'
      }, 
      {
        value: 'UNUSUAL_THIRST',
        label: 'Neuobičajena žeđ'
      },
      {
        value: 'FREQUENT_URINATION',
        label: 'Učestalo mokrenje'
      }, 
      {
        value: 'FATIGUE',
        label: 'Umor'    
      }, 
      {
        value: 'BLURRY_VISION',
        label: 'Zamagljen vid'
      }, 
      {
        value: 'PRESSURE_IN_LOWER_BELLY',
        label: 'Bolovi u abdomenu'
      }, 
      {
        value: 'DULL_BACKACHE',
        label: 'Bolovi u krstima'
      },
      {
        value: 'VAGINAL_BLEEDING',
        label: 'Vaginalno krvarenje'
      }

];

export const doctorSymptoms = patientSymptoms.concat(
    [
        {
            value: 'LOW_THROMBOCYES_COUNT',
            label: 'Nizak broj trombocita'
        },  
        {
            value: 'ELEVATED_LIVER_ENZYMES',
            label: 'Povišeni enzimi jetre'
        },  
        {
            value: 'INFECTIONS',
            label: 'Infekcija'
        },  
        {
            value: 'TOO_MUCH_AMNIOTIC_FLUID',
            label: 'Previše amniotičke tečnosti'
        } 
    ]); 

export const chromosomalDisorders = [
  {
    value: "NO_DISORDER",
    label: "Bez poremećaja"
  },
  {
    value: "DOWN",
    label: "Daunov sindrom"
  },
  {
    value: "EDWARDS",
    label: "Edvardov sindrom"
  },
  {
    value: "PATAU",
    label: "Patauov sindrom"
  },
];

export const illnesses = [
  {
    value: "Trudnicki dijabetes",
    label: "Trudnički dijabetes"
  },
  {
    value: "Eklampsija",
    label: "Eklampsija"
  },
  {
    value: "Preeklampsija",
    label: "Preeklampsija"
  },
  {
    value: "Bolest bubrega",
    label: "Bolest bubrega"
  },
  {
    value: "Dijabetes",
    label: "Dijabetes"
  },
  {
    value: "Hipertenzija",
    label: "Hipertenzija"
  },
];

export const statuses = [
  {
    value: "ABNORMAL",
    label: "Abnormalno"
  },
  {
    value: "NON_REASSURING",
    label: "Sumnjivo"
  },
  {
    value: "REASSURING",
    label: "Normalno"
  }
];
