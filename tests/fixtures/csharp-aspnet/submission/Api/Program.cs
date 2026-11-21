var builder = WebApplication.CreateBuilder(args);
builder.Services.AddSingleton<CourseService>();
var app = builder.Build();

app.MapGet("/courses", () => Results.Ok(new[] { "CS101", "CS102" }));
app.MapPost("/enroll", (EnrollmentRequest request, CourseService service) =>
{
    var course = service.FindAsync(request.CourseId ?? "").Result;
    return Results.Ok(new EnrollmentResult(course is not null, request.StudentId));
});
app.Run();

public record EnrollmentRequest(string? CourseId, string StudentId);
public record EnrollmentResult(bool Enrolled, string StudentId);
public record Course(string Id);
public sealed class CourseService
{
    public Task<Course?> FindAsync(string id) => Task.FromResult(id is "CS101" or "CS102" ? new Course(id) : null);
}
public partial class Program { }
