using System.Net;
using System.Net.Http.Json;
using Microsoft.AspNetCore.Mvc.Testing;
using Xunit;

public class EnrollmentTests : IClassFixture<WebApplicationFactory<Program>>
{
    private readonly HttpClient _client;
    public EnrollmentTests(WebApplicationFactory<Program> factory) => _client = factory.CreateClient();

    [Fact]
    public async Task ValidEnrollmentSucceeds()
    {
        var response = await _client.PostAsJsonAsync("/enroll", new { courseId = "CS101", studentId = "S1" });
        Assert.Equal(HttpStatusCode.OK, response.StatusCode);
    }

    [Fact]
    public async Task MissingCourseIsRejected()
    {
        var response = await _client.PostAsJsonAsync("/enroll", new { studentId = "S1" });
        Assert.Equal(HttpStatusCode.BadRequest, response.StatusCode);
    }
}
