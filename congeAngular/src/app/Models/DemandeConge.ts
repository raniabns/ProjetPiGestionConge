
export class DemandeConge{
    idConge!:number;
    dateDebut!: Date;
    dateFin!: Date;
    duree!:number;
    type!:TypeConge;

}
export enum TypeConge {
    conge_paye,
    conge_sanssolde,
    conge_annuel,
    conge_maladie,
    conge_maternite,
    conge_ordinaire,
    Travail}