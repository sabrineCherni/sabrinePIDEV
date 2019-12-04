using MailKit.Net.Smtp;
using MimeKit;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCConsumeWebApiCompetence.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            var message = new MimeMessage();
            message.From.Add(new MailboxAddress("Test Project", "fadi.kraiem@esprit.tn"));
            message.To.Add(new MailboxAddress("naren", "sagihi6571@imailt.com"));
            message.Subject = "Test";
            message.Body = new TextPart("plain")
            {
                Text = "hello world mail"
            };
            using (var client = new SmtpClient())
            {
                client.Connect("smtp.gmail.com", 587, false);
                client.Authenticate("fadi.kraiem@esprit.tn", "12387654");


                    client.Send(message);

                client.Disconnect(true);
                    }

                return View();
        }

        public ActionResult About()
        {
      
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}