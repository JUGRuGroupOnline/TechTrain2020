FROM mcr.microsoft.com/dotnet/core/sdk:3.1 AS build
WORKDIR /source

# copy csproj and restore as distinct layers
COPY *.sln .
COPY ./JugRu_Challenge2/*.csproj ./JugRu_Challenge2/
RUN dotnet restore

# copy everything else and build app
COPY ./JugRu_Challenge2/. ./JugRu_Challenge2/
WORKDIR /source/JugRu_Challenge2

RUN dotnet publish -c release -o /app

# final stage/image
FROM mcr.microsoft.com/dotnet/core/aspnet:3.1
WORKDIR /app
COPY --from=build /app ./
ENTRYPOINT ["dotnet", "JugRu_Challenge2.dll"]