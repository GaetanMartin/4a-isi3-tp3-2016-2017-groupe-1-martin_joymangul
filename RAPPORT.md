**Nom/Prénom Etudiant 1 : MARTIN Gaëtan**

**Nom/Prénom Etudiant 2 : JOYMANGUL Jensen**

# Rapport TP3

## Question 1

Deux méthodes sont à tester : 

```java
int getAge(GregorianCalendar date)
boolean wasBorn(GregorianCalendar date)
```

Ces deux méthodes prennent en paramètre d'entrée une date de type GregorianCalendar. 
Plusieurs classes d'équivalences apparaissent alors : 
- Si la date est passée (par rapport à l'anniversaire)
- Le jour de l'anniversaire
- Une Date future
- La date d'aujourd'hui
- Une date nulle
- L'age pour une année bissectile

+ ### Pour wasBorn

| Classes | Validité | Représentant | oracle  |  Contexte |
|---|---|---|---|---|
| Date passée | Valide | 30/03/1992 | false  | Né le 03/12/1993  |
| Date exacte | Valide |  03/12/1993 | true  |  Né le 03/12/1993 |
| Date future | Valide |  30/05/2017 | true  |  Né le 03/12/1993 |
| Date nulle | Invalide | null  | echec  |  Né le 03/12/1993 |

+ ### Pour getAge

| Classes | Validité | Représentant | oracle            |  Contexte |
|---|---|---|---|---|
| Date avant naissance |Invalide|04/04/1992 | Echec  | Né le 03/12/1993  |
| Date après naissance |Valide|04/05/2017  | 23  | Né le 03/12/1993  |
| Date d'anniversaire | Valide  |03/12/1993  | 0  | Né le 03/12/1993  |
| Date moins d'un an  | Valide  | 01/01/1994 | 0  | Né le 03/12/1993  |
| Date bisectile | Valide       | 29/02/2000 | 6   | Né le 03/12/1993  |
| Date nulle | Invalide         | null       | Echec   | Né le 03/12/1993  |


## Question 2

## Question 3

## Question 4

## Question 5

## Question 6

## Question 7

## Question 8
