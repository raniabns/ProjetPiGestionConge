export class ReclamationConge{
    idReclamation!:number;
    titre!:string;
    categorie!:CategorieReclamation;
    description!:string;
    dateReclamation!:Date;
}
export enum CategorieReclamation {
    High ,Meduim,Low
   }