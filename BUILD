package(default_visibility=["//visibility:public"])

java_library(
  name = "using-ranges-lib",
  srcs = glob(["src/main/java/**/*.java"]),
  deps = ["@com_google_guava_guava//jar"],
)

java_test(
  name = "tests",
  srcs = glob(["src/test/java/**/*.java"]),
  test_class = "org.invisibletech.useranges.AllTests",
  deps = [
       ":using-ranges-lib",
       "@com_google_guava_guava//jar",
       "@org_hamcrest_hamcrest_core//jar"
  ]
)