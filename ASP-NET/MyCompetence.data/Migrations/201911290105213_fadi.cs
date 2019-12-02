namespace MyCompetence.data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class fadi : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "competence.employe",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        email = c.String(maxLength: 255, unicode: false),
                        grade = c.String(maxLength: 255, unicode: false),
                        nom = c.String(maxLength: 255, unicode: false),
                        password = c.String(maxLength: 255, unicode: false),
                        prenom = c.String(maxLength: 255, unicode: false),
                        role = c.String(maxLength: 255, unicode: false),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "competence.t_competence",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        aptitude = c.String(maxLength: 255, unicode: false),
                        nom_employe = c.String(maxLength: 255, unicode: false),
                        savoir = c.String(maxLength: 255, unicode: false),
                        savoi_faire_operationnel = c.String(maxLength: 255, unicode: false),
                        savoir_faire_relationnel = c.String(maxLength: 255, unicode: false),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "dbo.Fichemetiers",
                c => new
                    {
                        FicheMetierId = c.Int(nullable: false, identity: true),
                        CompetenceRequis = c.String(unicode: false),
                        Description = c.String(unicode: false),
                        NiveauRequis = c.String(unicode: false),
                    })
                .PrimaryKey(t => t.FicheMetierId);
            
            CreateTable(
                "competence.t_communication",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        linguistique = c.String(maxLength: 255, unicode: false),
                        nom_employe = c.String(maxLength: 255, unicode: false),
                        socio_culturelle = c.String(maxLength: 255, unicode: false),
                        socio_linguistique = c.String(maxLength: 255, unicode: false),
                        strategique = c.String(maxLength: 255, unicode: false),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "competence.t_formation",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        nom_employe = c.String(maxLength: 255, unicode: false),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "competence.t_manager",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        email = c.String(maxLength: 255, unicode: false),
                        grade = c.String(maxLength: 255, unicode: false),
                        nom = c.String(maxLength: 255, unicode: false),
                        prenom = c.String(maxLength: 255, unicode: false),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "competence.t_quiz",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        question = c.String(maxLength: 255, unicode: false),
                        reponse = c.String(maxLength: 255, unicode: false),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "competence.t_competence_employe",
                c => new
                    {
                        Competence_id = c.Int(nullable: false),
                        employes_id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Competence_id, t.employes_id })
                .ForeignKey("competence.t_competence", t => t.Competence_id, cascadeDelete: true)
                .ForeignKey("competence.employe", t => t.employes_id, cascadeDelete: true)
                .Index(t => t.Competence_id)
                .Index(t => t.employes_id);
            
            CreateTable(
                "competence.employe_t_competence",
                c => new
                    {
                        employes_id = c.Int(nullable: false),
                        competences_id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.employes_id, t.competences_id })
                .ForeignKey("competence.employe", t => t.employes_id, cascadeDelete: true)
                .ForeignKey("competence.t_competence", t => t.competences_id, cascadeDelete: true)
                .Index(t => t.employes_id)
                .Index(t => t.competences_id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("competence.employe_t_competence", "competences_id", "competence.t_competence");
            DropForeignKey("competence.employe_t_competence", "employes_id", "competence.employe");
            DropForeignKey("competence.t_competence_employe", "employes_id", "competence.employe");
            DropForeignKey("competence.t_competence_employe", "Competence_id", "competence.t_competence");
            DropIndex("competence.employe_t_competence", new[] { "competences_id" });
            DropIndex("competence.employe_t_competence", new[] { "employes_id" });
            DropIndex("competence.t_competence_employe", new[] { "employes_id" });
            DropIndex("competence.t_competence_employe", new[] { "Competence_id" });
            DropTable("competence.employe_t_competence");
            DropTable("competence.t_competence_employe");
            DropTable("competence.t_quiz");
            DropTable("competence.t_manager");
            DropTable("competence.t_formation");
            DropTable("competence.t_communication");
            DropTable("dbo.Fichemetiers");
            DropTable("competence.t_competence");
            DropTable("competence.employe");
        }
    }
}
