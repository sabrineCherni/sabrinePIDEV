
using MyTimesheet.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTimesheet.Data.Infrastructure
{
    public interface IDatabaseFactory : IDisposable
    {
        Context DataContext { get; }
    }

}
