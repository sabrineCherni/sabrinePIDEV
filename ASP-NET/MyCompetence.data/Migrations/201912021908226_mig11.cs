namespace MyCompetence.data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class mig11 : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Reclamations",
                c => new
                    {
                        ReclamationId = c.Int(nullable: false, identity: true),
                        Titre = c.String(unicode: false),
                        Description = c.String(unicode: false),
                    })
                .PrimaryKey(t => t.ReclamationId);
            
            CreateTable(
                "dbo.Skills",
                c => new
                    {
                        SkillId = c.Int(nullable: false, identity: true),
                        NomEmploye = c.String(unicode: false),
                        TypeSkill = c.String(unicode: false),
                        NiveauSkill = c.String(unicode: false),
                    })
                .PrimaryKey(t => t.SkillId);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Skills");
            DropTable("dbo.Reclamations");
        }
    }
}
