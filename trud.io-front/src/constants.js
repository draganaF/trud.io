export const patientSymptoms = [
    {
        value: 0,
        label: 'Oticanje'
      },
      {
        value: 1,
        label: 'Dobijanje na težini'
      },
      {
        value: 2,
        label: 'Jake glavobolje'
      },
      {
        value: 3,
        label: 'Teškoće sa disanjem'
      },
        {
        value: 4,
        label: 'Napadi'
      },
        {
        value: 5,
        label: 'Gubitak svesti'
      },
       {
        value: 6,
        label: 'Mučnina'
      },
       {
        value: 7,
        label: 'Povraćanje'
      },
       {
        value: 8,
        label: 'Visok krvni pritisak'
      },
      {
        value: 9,
        label: 'Proteinurija'
      }, 
      {
        value: 11,
        label: 'Neuobičajena žeđ'
      },
      {
        value: 12,
        label: 'Učestalo mokrenje'
      }, 
      {
        value: 13,
        label: 'Umor'    
      }, 
      {
        value: 14,
        label: 'Zamagljen vid'
      }, 
      {
        value: 16,
        label: 'Bolovi u abdomenu'
      }, 
      {
        value: 17,
        label: 'Bolovi u krstima'
      },
      {
        value: 19,
        label: 'Vaginalno krvarenje'
      }

];

export const doctorSymptoms = patientSymptoms.concat(
    [
        {
            value: 10,
            label: 'Nizak broj trombocita'
        },  
        {
            value: 15,
            label: 'Povišeni enzimi jetre'
        },  
        {
            value: 18,
            label: 'Infekcija'
        },  
        {
            value: 20,
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
    value: "Trudnički dijabetes",
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
