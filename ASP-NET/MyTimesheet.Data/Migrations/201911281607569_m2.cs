namespace MyTimesheet.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class m2 : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "timesheetpidev.employe",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        email = c.String(maxLength: 255, unicode: false),
                        isActif = c.Boolean(nullable: false, storeType: "bit"),
                        nom = c.String(maxLength: 255, unicode: false),
                        password = c.String(maxLength: 255, unicode: false),
                        prenom = c.String(maxLength: 255, unicode: false),
                        role = c.String(maxLength: 255, unicode: false),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "timesheetpidev.tache",
                c => new
                    {
                        tache_ID = c.String(nullable: false, maxLength: 255, unicode: false),
                        valueFrom = c.DateTime(precision: 0),
                        status = c.String(maxLength: 255, unicode: false),
                        title = c.String(maxLength: 255, unicode: false),
                        valueTo = c.DateTime(precision: 0),
                        employe_id = c.Int(),
                        projet_id = c.Int(),
                    })
                .PrimaryKey(t => t.tache_ID)
                .ForeignKey("dbo.projets", t => t.projet_id)
                .ForeignKey("timesheetpidev.employe", t => t.employe_id)
                .Index(t => t.employe_id)
                .Index(t => t.projet_id);
            
            CreateTable(
                "dbo.projets",
                c => new
                    {
                        projet_ID = c.Int(nullable: false, identity: true),
                        title_projet = c.String(unicode: false),
                        projet_From = c.DateTime(precision: 0),
                        projet_To = c.DateTime(precision: 0),
                    })
                .PrimaryKey(t => t.projet_ID);
            
        }
        
        public override void Down()
        {
            DropForeignKey("timesheetpidev.tache", "employe_id", "timesheetpidev.employe");
            DropForeignKey("timesheetpidev.tache", "projet_id", "dbo.projets");
            DropIndex("timesheetpidev.tache", new[] { "projet_id" });
            DropIndex("timesheetpidev.tache", new[] { "employe_id" });
            DropTable("dbo.projets");
            DropTable("timesheetpidev.tache");
            DropTable("timesheetpidev.employe");
        }
    }
}
