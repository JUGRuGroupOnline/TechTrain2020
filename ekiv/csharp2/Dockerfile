#See https://aka.ms/containerfastmode to understand how Visual Studio uses this Dockerfile to build your images for faster debugging.

FROM mcr.microsoft.com/dotnet/core/aspnet:3.1-buster-slim AS base
WORKDIR /app

ENV ASPNETCORE_URLS=http://+:8282

EXPOSE 80
EXPOSE 8282

FROM mcr.microsoft.com/dotnet/core/sdk:3.1-buster AS build
WORKDIR /src
COPY ["csharp2.csproj", "./"]
RUN dotnet restore "csharp2.csproj"
COPY . .
WORKDIR "/src/"
RUN dotnet build "csharp2.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "csharp2.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "csharp2.dll"]
