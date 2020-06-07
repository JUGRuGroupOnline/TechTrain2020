#See https://aka.ms/containerfastmode to understand how Visual Studio uses this Dockerfile to build your images for faster debugging.

FROM mcr.microsoft.com/dotnet/core/aspnet:3.1-buster-slim AS base
WORKDIR /app
ENV ASPNETCORE_URLS=http://+:8383

EXPOSE 8383

FROM mcr.microsoft.com/dotnet/core/sdk:3.1-buster AS build
WORKDIR /src
COPY ["fsharp3.fsproj", "./"]
RUN dotnet restore "fsharp3.fsproj"
COPY . .
WORKDIR "/src/"
RUN dotnet build "fsharp3.fsproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "fsharp3.fsproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "fsharp3.dll"]
