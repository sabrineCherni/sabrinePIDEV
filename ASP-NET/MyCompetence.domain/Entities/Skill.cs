﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.domain.Entities
{
   public class Skill
    {
        [Key]
        public int SkillId { get; set; }

        public string NomEmploye { get; set; }

        public string  TypeSkill { get; set; }

        public string NiveauSkill { get; set; }

    }
}




/*
<!DOCTYPE html>

<html>
<head>

    <meta name = "viewport" content="width=device-width" />
    <title></title>

</head>
<body>

    <a href = "@Url.Action("Create", "Formation")"> add new competence formationc</a>
  
    <table class="table">
        <tr>
            <th>id</th>
            <th>formationc</th>
        </tr>
        @foreach(var p in ViewBag.result)
{
            < tr >
                < td > @p.id </ td >
                < td > @p.formationc </ td >
                < td >
                    @Html.ActionLink("Edit", "Edit", new { id = p.id }) |
                    @Html.ActionLink("Delete", "Delete", new { id = p.id })
                </ td >

            </ tr >

        }

    </table>


</body>
</html>
*/