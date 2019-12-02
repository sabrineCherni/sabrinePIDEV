using MyCompetence.Data.Infrastructure;
using MyCompetence.domain.Entities;
using MyCompetence.ServicePattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.service
{
    public class SkillService : Service<Skill>, ISkillService
    {

        static IDatabaseFactory factory = new DatabaseFactory();
        static IUnitOfWork UOW = new UnitOfWork(factory);
        public SkillService() : base(UOW)
        {

        }
    }
}
