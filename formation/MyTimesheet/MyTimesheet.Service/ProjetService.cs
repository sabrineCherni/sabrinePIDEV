using MyTimesheet.Data.Infrastructure;
using MyTimesheet.Domain.Entities;
using MyTimesheet.ServicePattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTimesheet.Service
{
    public class ProjetService : Service<projets>, IProjetService
    {
        static IDatabaseFactory factory = new DatabaseFactory();
        static IUnitOfWork UOW = new UnitOfWork(factory);
        public ProjetService() : base(UOW)
        {
                
        }
    }
}
